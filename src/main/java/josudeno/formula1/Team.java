package josudeno.formula1;

/**
 * Created by josh on 24/02/17.
 */
public class Team
{
    private Integer number;
    private Car car;
    private Driver driver;

    public Team(Integer number, Car car, Driver driver) {
        this.number = number;
        this.car = car;
        this.driver = driver;
    }

    public Car getCar() {
        return car;
    }

    public Driver getDriver() {
        return driver;
    }
}
