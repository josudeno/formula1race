package josudeno.formula1;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by josh on 24/02/17.
 */
public class Driver implements Observer
{
    private final Integer numberOfTeams;
    Car car;
    private float handlingFactor = 0.8f;

    public Driver(Car car, Integer numberOfTeams) {
        this.numberOfTeams = numberOfTeams;
        this.car = car;
    }

    public void amILast() {

    }

    private void assessPosition(Car otherCar) {
        if (otherCar.getCurrentDistance() <= (this.car.getCurrentDistance() - 10) ) {
            car.setSpeed(car.getSpeed() * handlingFactor);
        }
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Car) {
            this.assessPosition((Car) o);
            car.setElapsedTime((int)arg);
            System.out.println("*********Car ******* "+this.toString());
            System.out.println("current distance: "+car.getCurrentDistance());
            System.out.println("current speed: "+car.getSpeed());
            System.out.println("current topSpeed: "+car.getTopSpeed());
            System.out.println("Elapsed time: "+arg);
            System.out.println("################");
        }
    }
}
