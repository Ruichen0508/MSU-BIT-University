package car;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;


/**
 * @author : Alex
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        InputStream is = CarPainter.class.getClassLoader().getResourceAsStream("field.txt");
        FieldMatrix fm = FieldMatrix.load(new InputStreamReader(is));
        //FieldMatrix fm = new FieldMatrix(10,10);
        CarPainter p = new CarPainter(fm);
        BasicCarServer carServer = new BasicCarServer(fm, p);
        Car car = carServer.createCar();


//        is = CarPainter.class.getClassLoader().getResourceAsStream("script.txt");
//        Script script = Script.load(new InputStreamReader(is), car);
//        script.execute();

        class CarMover implements Runnable{
            private final String name;

            public CarMover(String name){
                this.name = name;
            }
            @Override
            public void run(){
                Random random = new Random();
                Car car = carServer.createCar();
                car.setName(name);
                CarServer.Direction direction = CarServer.Direction.DOWN;
                while(true){
                    boolean result;
                    try {
                        result = car.moveTo(direction);
                    }catch(ArrayIndexOutOfBoundsException e){
                        result = false;
                    }
                    if (!result){
                        direction = CarServer.Direction.values()[random.nextInt(4)];
                    }
                }

            }
        }
        class WallMover implements Runnable{

            public WallMover(){
            }
            @Override
            public synchronized void run(){
                while (true) {
                    Random random1 = new Random();
                    Random random2 = new Random();//用于生成随机数
                    int x = random1.nextInt(fm.rows);//分别代表矩阵fm中一个随机的行和列
                    int y = random2.nextInt(fm.cols);
                    if (fm.cells[x][y] == FieldMatrix.CellState.EMPTY ) {
                        fm.cells[x][y] = FieldMatrix.CellState.WALL;
                    } else {
                        fm.cells[x][y] = FieldMatrix.CellState.EMPTY;
                    }

                    try {
                        Thread.sleep(1000);  // 等待一段时间后再进行下一次操作
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        new Thread(new CarMover("Alex")).start(); //car1
        Thread.sleep(1000);
        new Thread(new CarMover("Petr")).start(); //car2
        Thread.sleep(1000);
        new Thread(new CarMover("Nata")).start(); //car3
        Thread.sleep(1000);
        new Thread(new CarMover("Boris")).start(); //car4
        Thread.sleep(1500);
        new Thread( new Thread(new WallMover())).start();






    }
}
