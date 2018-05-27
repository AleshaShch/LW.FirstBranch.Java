package com.model;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class describes the model of road. In application is only one object of class "Road".
 */
public class Road implements Runnable {
    private LinkedBlockingQueue<Car> carQueue = new LinkedBlockingQueue<Car>();
    private ArrayList<Lane> lanes = new ArrayList<Lane>(5);
    private int maxSpeed;
    private int counterForOffence;
    private int counterForMessage;
    private final static int MAX_SPEED = 90;

    public Road() {
        maxSpeed = 0;
        counterForOffence = 0;
        counterForMessage = 0;
        for (int i = 0; i < 5; i++) {
            lanes.add(new Lane(carQueue));
        }
    }

    public void addCar(Car newCar) {
        if (counterForMessage < 50) counterForMessage++;

        try {
            carQueue.put(newCar);
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
        ;
        if (maxSpeed < newCar.getSpeed()) maxSpeed = newCar.getSpeed();
        if (maxSpeed < MAX_SPEED) counterForOffence++;
    }

    /**
     * Method "run()" launches 5 lanes with ExecutorService.
     * @see ExecutorService
     */
    public void run() {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(lanes.get(i));
        }
    }

    public int getCounterForMessage() {
        return counterForMessage;
    }

    public void setCounterForMessage(int counterForMessage) {
        this.counterForMessage = counterForMessage;
    }

    public int showMaxSpeed() {
        return maxSpeed;
    }

    public int showOffence() {
        return counterForOffence;
    }

    public LinkedBlockingQueue<Car> getCarQueue() {
        return carQueue;
    }

    public ArrayList<Lane> getLanes() {
        return lanes;
    }

}
