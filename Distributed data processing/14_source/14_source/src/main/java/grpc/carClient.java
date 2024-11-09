package grpc;

import grpc.carservice.*;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

import java.util.Random;

public class carClient {
    // 定义方法 addCar，接受 CarServiceGrpc.CarServiceBlockingStub、String 和 String 类型的参数
    void addCar(CarServiceGrpc.CarServiceBlockingStub client, String name, String color) {
        new Thread(() -> {
            // 创建新线程
            // 创建新的车辆请求
            AddNewCarRequest newCarRequest = AddNewCarRequest.newBuilder()
                    .setName(name)
                    .setColor(color)
                    .build();
            // 调用 client 的 createCar 方法
            AddNewCarResponse newCarResponse = client.createCar(newCarRequest);
            // 获取新车辆的索引
            int carIndex = newCarResponse.getCarIndex();
            // 打印车辆索引
            System.out.println(carIndex);

            // 设置车辆颜色和名称
            SetCarColorRequest carColorRequest = SetCarColorRequest.newBuilder()
                    .setCarIndex(carIndex)
                    .build();
            client.setCarColor(carColorRequest);

            SetCarNameRequest carNameRequest = SetCarNameRequest.newBuilder()
                    .setCarIndex(carIndex)
                    .setName(name)
                    .build();
            client.setCarName(carNameRequest);

            Random random = new Random();
            Direction direction = Direction.values()[random.nextInt(4)];
            // 创建车辆移动请求
            MoveCarRequest request = MoveCarRequest.newBuilder()
                    .setCarIndex(newCarResponse.getCarIndex())
                    .setDirection(direction)
                    .setCount(random.nextInt(10))
                    .build();

            while (true) {
                MoveCarResponse result = client.moveCar(request);
                if (!result.getResult()) {
                    // 发生碰撞，输出信息并修改颜色和方向重新移动
                    System.out.println("There was a collision. Now change colors.");
                    changeColorAndMove(client, carIndex);
                }
            }
        }).start();
    }

    // 定义 changeColorAndMove 方法，改变颜色并重新移动车辆
    void changeColorAndMove(CarServiceGrpc.CarServiceBlockingStub client, int carIndex) {
        String newColor = generateRandomColor();
        // 修改车辆颜色请求
        SetCarColorRequest collisionColorRequest = SetCarColorRequest.newBuilder()
                .setCarIndex(carIndex)
                .setColor(newColor)
                .build();
        client.setCarColor(collisionColorRequest);

        Random random = new Random();
        Direction newDirection = Direction.values()[random.nextInt(4)];
        // 新的移动请求
        MoveCarRequest newMoveRequest = MoveCarRequest.newBuilder()
                .setCarIndex(carIndex)
                .setDirection(newDirection)
                .setCount(random.nextInt(4))
                .build();
        client.moveCar(newMoveRequest);
    }

    // 定义生成随机颜色的方法
    String generateRandomColor() {
        Random random = new Random();
        String[] colors = { "red", "blue", "green" };
        int index = random.nextInt(colors.length);
        return colors[index];
    }

    public static void main(String[] args) {
        // 创建连接到服务器的客户端
        CarServiceGrpc.CarServiceBlockingStub client = createClient("localhost", 8080);
        System.out.println("Connected to server.");

        // 创建 carClient 对象并添加车辆
        carClient car = new carClient();
        car.addCar(client, "Car1", "blue");
        car.addCar(client, "Car2", "green");
    }

    // 创建连接到服务器的方法
    private static CarServiceGrpc.CarServiceBlockingStub createClient(String host, int port) {
        Channel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        return CarServiceGrpc.newBlockingStub(channel);
    }
}