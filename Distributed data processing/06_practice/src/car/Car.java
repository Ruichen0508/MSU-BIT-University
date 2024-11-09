package car;

import java.awt.*;
import java.util.Random;

public class Car {
    private final CarServer carServer;

    private Position position;
    private static int count = 1;
    private int index;
    private int speed = 500;
    private Color color;
    private String name;

    public Car(CarServer carServer, Position position){
        this.carServer = carServer;
        this.position = position;
        speed = new Random().nextInt(300) + 300;
        index = count++;
        color = new Color((int)(Math.random() * 0x1000000));
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){return color;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public void destroy(){
        carServer.destroyCar(this);
    }

    public boolean moveTo(CarServer.Direction direction){
        try {
            Thread.sleep(speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取下一步位置
        Position nextPosition = position.move(direction);
        if (carServer.isPositionEmpty(nextPosition)) {
            if (carServer.moveCarTo(this, direction)) {
                position = nextPosition; // 移动到下一步位置
                return true;
            } else {
                return false;
            }
        } else {
            // 下一步位置有墙，无法移动
            return false;
        }
        //if (carServer.moveCarTo(this,direction)){
            //position = position.move(direction);
            //return true;
        //}else
            //return false;

    }
    public Position getPosition(){return position;}

    public int getIndex(){return index;}
}
