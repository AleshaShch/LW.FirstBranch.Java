package com.model;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;


/**
 * Class "Car" describes the model of car. Each car is separate thread.
 */
public class Car implements Runnable{
    private int speed;

    public Car (int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    /**
     * This method emulates machine movement.
     */
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Interrupted run()");
        }
        System.out.println(speed);
    }
}
