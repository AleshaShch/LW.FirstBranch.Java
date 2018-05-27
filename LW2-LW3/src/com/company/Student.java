package com.company;

import java.util.ArrayList;

public class Student {
    private final String fullName;
    private final ArrayList<Integer> marks;
    private Lecture lecture;
    private ArrayList<Student> studentsList;

    Student() {
        fullName = null;
        marks = null;
    }
    Student(String tempString) {
        fullName = tempString;
        marks = new ArrayList<Integer>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String getTopicLecture() {
        return lecture.getTopic();
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }
}
