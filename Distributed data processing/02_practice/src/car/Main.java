package car;

import java.awt.*;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : Alex
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        int max_row=10,max_cols=15;
        FieldMatrix fm = new FieldMatrix(max_row,max_cols);
        CarPainter p = new CarPainter(fm);
        BasicCarServer carServer = new BasicCarServer(fm, p);
        Car car = carServer.createCar();
        car.setName("Alex");
        car.setColor(Color.BLUE);
        CarServer.Direction direct = CarServer.Direction.DOWN_RIGHT;
        while(true)
        {
            Position pos = new Position(car.getPosition().row, car.getPosition().col);
            pos = pos.move(direct);
            if(pos.row >= max_row){
                if(direct == CarServer.Direction.DOWN_LEFT) {
                    direct = CarServer.Direction.UP_LEFT;
                }
                else if(direct == CarServer.Direction.DOWN_RIGHT){
                    direct = CarServer.Direction.UP_RIGHT;
                }
                continue;
            }
            if(pos.row < 0){
                if(direct == CarServer.Direction.UP_RIGHT) {
                    direct = CarServer.Direction.DOWN_RIGHT;
                }
                else if(direct == CarServer.Direction.UP_LEFT){
                    direct = CarServer.Direction.DOWN_LEFT;
                }
                continue;
            }
            if(pos.col >= max_cols){
                if(direct == CarServer.Direction.DOWN_RIGHT) {
                    direct = CarServer.Direction.DOWN_LEFT;
                }
                else if(direct == CarServer.Direction.UP_RIGHT){
                    direct = CarServer.Direction.UP_LEFT;
                }
                continue;
            }
            if(pos.col < 0){
                if(direct == CarServer.Direction.DOWN_LEFT) {
                    direct = CarServer.Direction.DOWN_RIGHT;
                }
                else if(direct == CarServer.Direction.UP_LEFT){
                    direct = CarServer.Direction.UP_RIGHT;
                }
                continue;
            }
//
//            System.out.println(new_pos);
            car.moveTo(direct);

        }
    }
}
