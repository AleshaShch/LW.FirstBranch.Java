package com.model;

import java.util.ArrayList;

/**
 * The class represent the model of student.
 */
public class Student extends AbstractStudent {
    private final ArrayList<Integer> marks;
    //private ArrayList<Student> studentsList;

    public Student(String fullName) {
        super(fullName);
        marks = new ArrayList<Integer>();
    }

    public void beHappy() {
        System.out.println("Everything is OK");
    }

}
