package com.model;

import java.util.ArrayList;

/**
 * This class provide connection between teacher and starosta.
 * Journal consist of journal line.
 */
public class Journal {
    private ArrayList<JournalLine> journalLines;
    private ArrayList<Student> listOfStudents = new ArrayList<Student>();

    public Journal() {
        journalLines = new ArrayList<JournalLine>();
    }

    public void setStudentList(ArrayList<Student> listOfStudent) {
        this.listOfStudents = listOfStudent;
    }

    public void setStudent(Student student) {
        listOfStudents.add(student);
        JournalLine journalLine = new JournalLine(student.getFullName());
        journalLines.add(journalLine);
    }

    public ArrayList<Student> getJournalInfo() {
        return listOfStudents;
    }

    public void setAttendance(String fullName, char temp) {
        for (JournalLine it : journalLines) {
            if (it.getFullName() == fullName) it.NoteAttendance(temp);
        }
    }
}
