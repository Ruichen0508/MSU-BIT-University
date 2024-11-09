package car;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Random;

public class Car {
    private final CarServer carServer;

    private Position position;
    private static int count = 1;
    private int index;
    private int speed = 500;
    private Color color;
    private String name;
    private LocalDateTime lastOperation;

    public Car(CarServer carServer, Position position){
        this.carServer = carServer;
        this.position = position;
        speed = new Random().nextInt(300) + 300;
        index = count++;
        color = new Color((int)(Math.random() * 0x1000000));
        lastOperation = LocalDateTime.now();
    }

    public void setColor(Color color){
        this.color = color;
        carServer.carParameterChanged(this);
    }

    public Color getColor(){return color;}
    public String getName(){return name;}
    public void setName(String name){
        this.name = name;
        carServer.carParameterChanged(this);
    }
    public LocalDateTime getLastOperation(){return lastOperation;}
    public void destroy(){
        carServer.destroyCar(this);
    }

    public boolean moveTo(CarServer.Direction direction){
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            // 记录最后一次操作的时间
            lastOperation = LocalDateTime.now();
            // 调用 carServer 的 moveCarTo 方法尝试移动汽车
            if (carServer.moveCarTo(this, direction)) {
                // 如果移动成功，更新汽车的位置并返回 true
                position = position.move(direction);
                return true;
            } else
                return false;
        }catch(ArrayIndexOutOfBoundsException e){
            return false;
        }

    }
    public Position getPosition(){return position;}

    public int getIndex(){return index;}

    @Override
    public String toString(){
        return "Car: index="+index;
    }
}
