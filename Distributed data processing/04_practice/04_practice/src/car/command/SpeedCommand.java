package car.command;
import car.Car;

public class SpeedCommand implements Command{
    private final Car car;
    private final int speed;
    public SpeedCommand(Car car, int speed)
    {
        this.car = car;
        this.speed = speed;
    }
    @Override
    public boolean execute() {
        car.setSpeed(speed);
        return false;
    }
}