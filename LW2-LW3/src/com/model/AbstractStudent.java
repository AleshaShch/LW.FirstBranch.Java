package com.model;

/**
 * General class for all students.
 */
public abstract class AbstractStudent {
    protected final String fullName;
    protected Lecture lecture;

    public AbstractStudent(String fullName) {
        this.fullName = fullName;
    }

    abstract void beHappy();

    public String getFullName() {
        return fullName;
    }

    public void attendLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public String getLectureTopic() {
        return lecture.topic;
    }
}
