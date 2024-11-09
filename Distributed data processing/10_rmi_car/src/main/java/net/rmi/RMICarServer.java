package net.rmi;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import car.Car;
import car.command.Command;
import net.command.SerializableCommand;
import car.BasicCarServer;
import car.CarPainter;
import car.FieldMatrix;

public class RMICarServer implements RemoteCarServer {
    // 实现远程接口中的方法Remote Interface
    @Override
    public Object executeCommand(SerializableCommand command) throws RemoteException {
        System.out.println(Thread.currentThread().getId());
        // 执行相应的命令并返回结果
        return Command.createCommand(BasicCarServer.getServer().getCar(command.carIndex),
                command.commandName + " " + command.commandparameter).execute();
    }

    public static void main(String[] args) {
        int port = 8080;

        try {
            // 从文件加载地图矩阵数据 Load Map
            InputStream is = CarPainter.class.getClassLoader().getResourceAsStream("Field10x10.txt");
            FieldMatrix fm = FieldMatrix.load(new InputStreamReader(is));
            //创建 CarPainter 对象
            CarPainter p = new CarPainter(fm);
            // 创建 BasicCarServer 对象并传入参数
            BasicCarServer carServer = new BasicCarServer(fm, p);
            // 创建 RMICarServer 实例
            RMICarServer s = new RMICarServer();
            // 创建 RMI 注册表
            Registry registry = LocateRegistry.createRegistry(port);
            // 导出 RMICarServer 对象为远程对象Remote Object
            RemoteCarServer stub = (RemoteCarServer) UnicastRemoteObject.exportObject(s, 0);
            // 将远程对象绑定到注册表中，以便客户端访问Bind to Registry
            registry.bind("RMICarServer", stub);
            System.out.println("Server ready");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
