package grpc;

import car.*;
import car.util.ColorFactory;
import com.google.protobuf.Empty;
import grpc.carservice.AddNewCarResponse;
import grpc.carservice.CarServiceGrpc;
import grpc.carservice.MoveCarResponse;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class carServer extends CarServiceGrpc.CarServiceImplBase {
    public BasicCarServer basicCarServer;

    public static void main(String[] args) throws Exception {
        // 从类路径加载 Field10x10.txt 资源文件，并获取其输入流
        InputStream is = CarPainter.class.getClassLoader().getResourceAsStream("Field10x10.txt");
        // 使用输入流初始化 FieldMatrix 对象 fm
        FieldMatrix fm = FieldMatrix.load(new InputStreamReader(is));
        // 使用 FieldMatrix 对象 fm 初始化 CarPainter 对象 p
        CarPainter p = new CarPainter(fm);
        // 为端口号 8080 创建一个新的 ServerBuilder，添加一个新的 carServer 实例到服务器
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new carServer(fm, p))
                .build();
        // 启动服务器
        server.start();
        // 输出 "Server started"
        System.out.println("Server started");
        // 等待服务器终止
        server.awaitTermination();
    }

    // 构造函数，接收 FieldMatrix 和 CarEventsListener 类型的参数
    public carServer(FieldMatrix fieldMatrix, CarEventsListener carEventsListener) {
        // 使用 fieldMatrix 和 carEventsListener 创建 BasicCarServer 对象并赋值给 basicCarServer
        basicCarServer = BasicCarServer.createCarServer(fieldMatrix, carEventsListener);
    }

    // 创建车辆方法，接收 AddNewCarRequest 和 StreamObserver 参数
    @Override
    public void createCar(grpc.carservice.AddNewCarRequest request,
                          io.grpc.stub.StreamObserver<grpc.carservice.AddNewCarResponse> responseObserver) {
        // 创建车辆对象
        Car car = this.basicCarServer.createCar();
        // 设置车辆名称和颜色为请求中的值
        car.setName(request.getName());
        car.setColor(ColorFactory.getColor(request.getColor()));
        // 创建并传递响应给观察者，通知操作已完成
        AddNewCarResponse response = AddNewCarResponse.newBuilder().setCarIndex(car.getIndex()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // 设置车辆颜色方法，接收 SetCarColorRequest 和 StreamObserver 参数
    @Override
    public void setCarColor(grpc.carservice.SetCarColorRequest request,
                            io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
        // 获取指定车辆并设置颜色
        this.basicCarServer.getCar(request.getCarIndex())
                .setColor(ColorFactory.getColor(request.getColor()));
        // 创建并传递空的响应给观察者，通知操作已完成
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }

    // 移动车辆方法，接收 MoveCarRequest 和 StreamObserver 参数
    @Override
    public void moveCar(grpc.carservice.MoveCarRequest request,
                        io.grpc.stub.StreamObserver<grpc.carservice.MoveCarResponse> responseObserver) {
        Car car = this.basicCarServer.getCar(request.getCarIndex()); // 获取指定车辆
        CarServer.Direction direction = CarServer.Direction.values()[request.getDirection().getNumber()]; // 获取移动方向
        boolean success = car.moveTo(direction); // 尝试移动车辆

        if (!success) { // 如果移动失败
            String newColor = generateRandomColor(); // 生成随机颜色
            car.setColor(ColorFactory.getColor(newColor)); // 设置车辆新颜色
        }

        // 创建并传递响应给观察者，通知操作已完成
        MoveCarResponse response = MoveCarResponse.newBuilder().setResult(success).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    // 生成随机颜色方法
    String generateRandomColor() {
        Random random = new Random();
        String[] colors = { "red", "blue", "green", "yellow" };
        int index = random.nextInt(colors.length);
        return colors[index];
    }

    // 设置车辆名称方法，接收 SetCarNameRequest 和 StreamObserver 参数
    @Override
    public void setCarName(grpc.carservice.SetCarNameRequest request,
                           io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
        // 设置指定车辆的名称
        this.basicCarServer.getCar(request.getCarIndex()).setName(request.getName());
        // 创建并传递空的响应给观察者，通知操作已完成
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}