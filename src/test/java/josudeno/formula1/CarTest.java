package josudeno.formula1;

import junit.framework.TestCase;
import org.junit.Test;

public class CarTest extends TestCase
{

    @Test
    public void testSpeed() {
        Car car1 = new Car(1);
        car1.setElapsedTime(25);
        assertEquals(50.0f, car1.getSpeed());

        Car car2 = new Car(4);
        car2.setElapsedTime(10);
        assertEquals(20.0f, car2.getSpeed());

    }

    @Test
    public void testMaxSpeed() {
        Car car = new Car(1);
        car.setElapsedTime(1);
        assertEquals(160.0f, car.getTopSpeed());

        Car car2 = new Car(5);
        car2.setElapsedTime(1);
        assertEquals(200.0f, car2.getTopSpeed());
    }

    @Test
    public void testDistance() {
        Car car1 = new Car(1);
        car1.setElapsedTime(25);
        assertEquals(625.0f, car1.getCurrentDistance());

        Car car2 = new Car(4);
        car2.setElapsedTime(10);
        assertEquals(400.0f, car2.getCurrentDistance());

        Car car3 = new Car(1);
        car3.setElapsedTime(200);
        assertEquals(40000.0f, car3.getCurrentDistance());

        Car car4 = new Car(20);
        car4.setElapsedTime(18);
        assertEquals(6480.0f, car4.getCurrentDistance());
    }
}
