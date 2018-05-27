package com.model;

/**
 * Class "Starosta" describes the model of starosta.
 */
public class Starosta extends Student {
    private Journal journal;

    public Starosta(String fullName) {
        super(fullName);
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    /**
     * This method is used to find and note not absent students.
     * @return the list that include full names of not absent students.
     */
    public String[] NoteAbsentStarosta() {
        String error[] = {"На лекции студентов нет или нет лекции"};
        if (journal.getJournalInfo().isEmpty() || lecture == null) return error;
        int i = 0;
        String[] tempStr = new String[journal.getJournalInfo().size()];
        for (AbstractStudent it : journal.getJournalInfo()) {
            if (lecture.topic == it.getLectureTopic())
                tempStr[i] = it.getFullName();
            i++;
        }
        return tempStr;
    }

}
