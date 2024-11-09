package client;

import car.webservice.Direction;
import car.webservice.Server;
import car.webservice.ServerService;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;

public class Client {
    public static void main(String[] args) throws Exception {
        String url = "http://127.0.0.1:8080/CarServer?wsdl";
        // 设置服务器地址
        ServerService service = new ServerService(new URL(url));
        // 创建对服务器的服务
        Server serverPort = service.getServerPort();
        // 获取服务器端口

        for (int i = 0; i < 3; i++) { // Создать три машинки // 循环三次以创建三辆车
            int carIndex = serverPort.createCar();
            // 创建一辆车，并获得车辆的索引
            System.out.println("Car " + carIndex + " created!");
            serverPort.setCarName(carIndex, "Car" + carIndex);
            // 为车辆设置名称
            Thread carThread = new Thread(() -> {
                // 新建线程，每个线程代表一辆车thread
                try {
                    boolean notWall;
                    Object[] arr = Arrays.stream(Direction.values()).toArray();
                    // 获取所有方向的数组
                    Direction dir = (Direction) arr[new Random().nextInt(4)];
                    // 随机选择一个方向

                    while (true) {
                        serverPort.setCarColor(carIndex, "yellow");
                        // 设置车辆颜色为黄色
                        notWall = serverPort.moveCarTo(carIndex, dir);
                        // 尝试移动车辆
                        if (!notWall) {//If you hit the wall.
                            while (!notWall) {
                                serverPort.setCarColor(carIndex, "blue");
                                // 设置车辆颜色为蓝色
                                dir = (Direction) arr[new Random().nextInt(4)];
                                // 重新选择一个方向
                                notWall = serverPort.moveCarTo(carIndex, dir);
                                // 再次尝试移动车辆
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            carThread.start(); // Запустить поток для каждой машинки// 启动每辆车的线程
        }
    }
}