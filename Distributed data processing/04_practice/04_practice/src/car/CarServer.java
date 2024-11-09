package car;

public interface CarServer {
    enum Direction{
        UP,DOWN,LEFT,RIGHT,LEFTUP,LEFTDOWN,RIGHTUP,RIGHTDOWN
    }

    Car createCar();
    void destroyCar(Car car);
    boolean moveCarTo(Car car, Direction direction);

}
