package com.vc;

import com.model.University;

import javax.swing.*;

/**
 * The program is simple model of university.
 *
 * @author Aliaksei Shchahrykovich
 * @version 1.0
 * @since 2018-03-31
 */
public class Main {

    /**
     * This method start execution of application at separate thread.
     * @param args not used in @version 1.0
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PrimaryController primaryController = new PrimaryController(new University());
            }
        });
    }
}
