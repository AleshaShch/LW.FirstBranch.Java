package com.model;

import java.util.ArrayList;

/**
 * This class describes the model of common lecture.
 */
public class Lecture extends AbstractClasses {
    public final String topic;
    private ArrayList<AbstractStudent> studentInUniversity = new ArrayList<AbstractStudent>();

    public Lecture(String topic) {
        this.topic = topic;
    }

}
