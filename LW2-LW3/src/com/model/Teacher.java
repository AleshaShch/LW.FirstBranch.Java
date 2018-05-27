package com.model;

/**
 * This class describes the model of teacher.
 */
public class Teacher {
    private final String fullName;
    private Lecture lecture;
    private Journal journal;

    Teacher(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void GiveLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    /**
     * The method is used to find and note not absent students in journal.
     * @return the list that include full names of not absent students.
     */
    public String[] NoteAbsent() {
        String error[] = {"На лекции студентов нет или нет лекции"};
        if (journal.getJournalInfo().isEmpty() || lecture == null) return error;
        int i = 0;
        String[] tempStr = new String[journal.getJournalInfo().size()];
        for (AbstractStudent it : journal.getJournalInfo()) {
            if (lecture.topic == it.getLectureTopic()) {
                tempStr[i] = it.getFullName();
                journal.setAttendance(it.getFullName(), 'n');
            } else journal.setAttendance(it.getFullName(), 'a');
            i++;
        }
        return tempStr;
    }
}
