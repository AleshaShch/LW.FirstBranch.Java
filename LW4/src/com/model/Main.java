package com.model;

import com.vc.MainWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.*;
import java.lang.*;

/**
 * The program is model of road. Multithreading is base for this application.
 *
 * @author Aliaksei Shchahrykovich
 * @version 1.0
 * @since 2018-04-13
 */

public class Main {
    private static final int MIN_BOUND = 1;
    private static final int MAX_BOUND = 220;

    /**
     * This method launches the application and provide executing into two threads.
     * First thread perform GUI, second thread contains infinite cycle that adds car to road.
     *
     * @param args not used in @version 1.0
     */
    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());
        Road road = new Road();

        new Thread(()-> {
            MainWindow mainWindow = new MainWindow(road);
        }).start();

        new Thread(() -> {
            int speed;
            while (true ) {
                if (road.getCarQueue().size() < 50) {
                    speed = MIN_BOUND + rnd.nextInt(MAX_BOUND - MIN_BOUND + 1);
                    Car car = new Car(speed);
                    road.addCar(car);
                }
            }
        }).start();
    }
}

