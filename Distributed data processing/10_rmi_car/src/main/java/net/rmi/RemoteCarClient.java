package net.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

import car.Car;
import car.CarServer;
import net.command.SerializableCommand;

public class RemoteCarClient {

    public static void main(String[] args) {
        int port = 8080;
        String host = "localhost";
        try {
            // 获取 RMI 注册表
            Registry registry = LocateRegistry.getRegistry(host, port);
            System.out.println("registry :" + host + ":" + port);
            // 获取远程服务器对象
            RemoteCarServer server = (RemoteCarServer) registry.lookup("RMICarServer");
            // 执行远程 CREATECAR 命令并获取车辆编号
            int carIndex = (int) server.executeCommand(new SerializableCommand(0, "CREATECAR", "Alex"));
            //创建一个 Mover 实例并运行
            (new Mover(new CarServerApi(server, carIndex))).run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

interface CarApi {
    //定义了小车控制的基本方法，例如 move()
    boolean move(CarServer.Direction dir) throws Exception;
}

class CarServerApi implements CarApi {
    //实现了 CarApi 接口。它包含一个远程服务器对象和车辆索引，用于实现 move() 方法来执行远程移动命令。
    RemoteCarServer server;
    int carIndex;

    public CarServerApi(RemoteCarServer server, int carIndex) {
        this.server = server;
        this.carIndex = carIndex;
    }

    @Override
    public boolean move(CarServer.Direction dir) throws Exception {
        return (boolean) server
                .executeCommand(new SerializableCommand(carIndex, dir.toString().toUpperCase(), "1"));

    }

}

class Mover {
    private CarApi api;
    CarServer.Direction dir;

    public Mover(CarApi api) {
        this.api = api;
    }

    public void run() throws Exception {
        Random rng = new Random();//生成一个随机数
        dir = CarServer.Direction.values()[rng.nextInt(4)];//并将其作为小车的初始移动方向

        while (true) {
            Thread.sleep(10);

            while (!api.move(dir)) {//如果移动失败
                dir = CarServer.Direction.values()[rng.nextInt(4)];//重新随机选择一个新的方向
                System.out.println("A collision has occurred and now changes direction to " + dir);
            }
        }
    }

}
