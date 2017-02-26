package josudeno.formula1;

import java.util.Observable;

/**
 * Created by josh on 24/02/17.
 */
public class Car extends Observable
{
    private int carNumber;
    private float initialVelocity = 0;
    private float topSpeed = 150;
    private float acceleration = 2;
    private float speed;
    private boolean nitroUsed = false;
    private float secondsPassed;
    private float currentSpeed;

    public Car(int carNumber) {
        this.carNumber = carNumber;
    }

    /**
     * Top speed is (150 + 10*i) km per hour
     *
     * @return
     */
    public float getTopSpeed() {
        return topSpeed + (10 * carNumber);
    }

    /**
     * Acceleration is (2*i) meter per second square.
     *
     * @return float
     */
    public float getAcceleration() {
        return acceleration * carNumber;
    }

    public float getCurrentDistance() {
        Float distance = (initialVelocity * this.secondsPassed) + (0.5f * getAcceleration()) * (this.secondsPassed * this.secondsPassed);
        return distance;
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

    /**
     * Returns the current speed.
     *
     * @return
     */
    public float getSpeed() {
        currentSpeed = 0 + this.acceleration * this.secondsPassed;
        return currentSpeed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setElapsedTime(Integer elapsedTime) {
        this.secondsPassed = elapsedTime;
    }

    public void updateStatus(int seconds) {
        this.setChanged();
        notifyObservers(seconds);
    }
}
