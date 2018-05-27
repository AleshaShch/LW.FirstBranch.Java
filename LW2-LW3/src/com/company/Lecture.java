package com.company;

public class Lecture extends Classes{
    private final String topic;

    Lecture(String tempStr) {
        topic = tempStr;
    }

    public String getTopic() {
        return topic;
    }
}
