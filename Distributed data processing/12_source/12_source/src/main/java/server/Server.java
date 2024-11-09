package server;

import car.*;
import car.util.ColorFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

@WebService
public class Server {
    BasicCarServer carServer;
    public static final String url = "http://0.0.0.0:8080/CarServer";

    protected Server(FieldMatrix fieldMatrix, CarEventsListener carEventsListener) {
        carServer = BasicCarServer.createCarServer(fieldMatrix, carEventsListener);
    }
    // 构造函数，接受场地矩阵和车辆事件监听器
    // 使用场地矩阵和车辆事件监听器创建基本车辆服务器

    @WebMethod
    public int createCar() {
        Car car = carServer.createCar();
        return car.getIndex();
    }
    // 创建车辆，并返回其索引
    @WebMethod
    public void destroyCar(int carIndex) {
        Car car = carServer.getCar(carIndex);
        carServer.destroyCar(car);
    }
    // 销毁给定索引的车辆
    @WebMethod
    public boolean moveCarTo(int carIndex, CarServer.Direction direction) {
        Car car = carServer.getCar(carIndex);
        boolean ret = false;
        try {
            ret = car.moveTo(direction);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return ret;
    }
    // 尝试移动车辆到指定方向
    @WebMethod
    public void setCarName(int carIndex, String name){
        carServer.getCar(carIndex).setName(name);
    }
    // 设置车辆名称
    @WebMethod
    public void moveCarRandomly(int carIndex) {
        Car car = carServer.getCar(carIndex);
        if (car != null) {
            CarServer.Direction randomDirection = generateRandomDirection();
            car.moveTo(randomDirection);
        }
    }
    // 随机移动车辆
    private CarServer.Direction generateRandomDirection() {
        // Генерация случайного направления
        // случайного направления
        // 生成随机方向
        // 你的随机方向生成逻辑实现
        //return CarServer.Direction.RIGHT;
        Random random = new Random();
        CarServer.Direction[] directions = CarServer.Direction.values();
        return directions[random.nextInt(directions.length)];
    }

    @WebMethod
    public void setCarColor(int carIndex, String color) {
        Car car = carServer.getCar(carIndex);
        if (car != null) {
            car.setColor(ColorFactory.getColor(color));
        }
    }
    // 设置车辆颜色

    public static void main(String[] args) {
        InputStream is = CarPainter.class.getClassLoader().getResourceAsStream("Field10x10.txt");
        FieldMatrix fm = FieldMatrix.load(new InputStreamReader(is));
        CarPainter p = new CarPainter(fm);
        Server server = new Server(fm,p);
        Endpoint.publish(url, server);
    }
}
