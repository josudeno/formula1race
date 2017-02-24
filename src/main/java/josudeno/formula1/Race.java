package josudeno.formula1;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by josh on 24/02/17.
 */
public class Race implements Runnable {
    private long elapsedTime;
    private Hashtable<Integer, Team> teams = new Hashtable<>();
    private Integer teamsAmount;
    private float length;
    private Instant startTime;

    public Race(Integer teams, float length) {
        this.teamsAmount = teams;
        this.length = length;
    }

    public void prepareRace() {

        for (Integer x = 1; x < this.teamsAmount+1; x++) {
            Car car = new Car();
            this.teams.put(x, new Team(x, car, new Driver(car, this.teamsAmount)));
        }

        for (Team team: teams.values()) {
            for (Team team1: teams.values()) {
                Driver d = team1.getDriver();
                team.getCar().addObserver(d);
            }
        }
        startTime = Instant.now();
    }

    @Override
    public void run() {
        elapsedTime = Duration.between(this.startTime, Instant.now()).getSeconds();

        for (Team team: teams.values()) {
            team.getCar().updateStatus((int) elapsedTime);
        }
    }
}
