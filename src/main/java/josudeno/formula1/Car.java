package josudeno.formula1;

import java.util.Observable;

/**
 * Created by josh on 24/02/17.
 */
public class Car extends Observable
{

    private float topSpeed = 150;
    private float acceleration = 2;
    /** Expressed in meters */
    private float currentDistance;
    private float speed;
    private boolean nitroUsed = false;
    private float secondsPassed;


    /**
     * Top speed is (150 + 10*i) km per hour
     *
     * @return
     */
    public float getTopSpeed() {
        return topSpeed;
    }

    public float setTopSpeed(Integer i) {
        return topSpeed + (10 * i);
    }

    /**
     * Acceleration is (2*i) meter per second square.
     *
     * @return float
     */
    public void accelerate(Integer second) {
        currentDistance = acceleration * second;
    }

    public float getCurrentDistance() {
        return currentDistance;
    }


    public float useNitro() {
        if (!nitroUsed) {
            if (speed*2 < topSpeed) {
                speed *= 2;
            } else {
                speed = topSpeed;
            }
        }
        return speed;
    }

    public float getSpeed() {
        speed = currentDistance * 12960;
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void updateStatus(int seconds) {
        this.secondsPassed = seconds;
        this.setChanged();
        notifyObservers(seconds);
    }
}
