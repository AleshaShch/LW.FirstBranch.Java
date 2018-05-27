package com.model;

import java.util.concurrent.LinkedBlockingQueue;

import static java.lang.Thread.sleep;

/**
 * This class describes the model of line. Each line performed in separate thread.
 */

public class Lane implements Runnable {
    private LinkedBlockingQueue<Car> carQueue = new LinkedBlockingQueue<Car>();
    private final static int MAX_SPEED = 90;

    public Lane(LinkedBlockingQueue<Car> carQueue) {
        this.carQueue = carQueue;
    }

    /**
     * Method "run()" of class Road execute next actions:
     * 1. take a car from queue;
     * 2. measure speed of machine.
     * Based on the speed each line controls cars.
     *
     * @see InterruptedException
     */
    public void run() {
        try{
            while(!Thread.interrupted()) {
                Car car = carQueue.take();
                if (car.getSpeed() < MAX_SPEED) {
                    Thread threadForCar = new Thread(car);
                    threadForCar.run();
                }
            }
        }catch (InterruptedException e) {
            System.out.println("Exception during run()");
        }
    }
}
