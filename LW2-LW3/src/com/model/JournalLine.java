package com.model;

import java.util.ArrayList;

/**
 * Object of this class contains elementary information about one student.
 */
public class JournalLine {
    private final String fullName;
    private final ArrayList<Character> attendance = new ArrayList<Character>();

    public JournalLine(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void NoteAttendance(char symbolOfAttendance) {
        attendance.add(symbolOfAttendance);
    }
}
