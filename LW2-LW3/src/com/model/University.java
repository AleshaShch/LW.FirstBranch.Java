package com.model;

import java.util.ArrayList;

/**
 *
 */
public class University {
    private ArrayList<Teacher> listOfTeachers = new ArrayList<Teacher>();
    private ArrayList<AbstractStudent> listOfStudents = new ArrayList<AbstractStudent>();
    public ArrayList<AbstractClasses> listOfClasses = new ArrayList<AbstractClasses>();
    public Journal journal;

    public University() {
    }

    /**
     * The method is used to add student to list of students and journal list.
     * @param fullName full name of single student.
     */
    public void enrollStudent(String fullName) {
        Student student = new Student(fullName);
        listOfStudents.add(student);
        journal.setStudent(student);
    }

    /**
     * The method is used to add starosta to list of students, journal list and give statosta the journal.
     * @param fullName full name of starosta.
     */
    public void enrollStarosta(String fullName) {
        Starosta starosta = new Starosta(fullName);
        listOfStudents.add(starosta);
        journal.setStudent(starosta);
        starosta.setJournal(journal);
    }

    /**
     * The method is used to add teacher to list of teachers and give each teacher the journal.
     * @param fullName full name of teacher.
     */
    public void employTeacher(String fullName) {
        Teacher teacher = new Teacher(fullName);
        listOfTeachers.add(teacher);
        teacher.setJournal(journal);
    }

    private void composeSchedule(String topic) {
        listOfClasses.add(new Lecture(topic));
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    /**
     * This method add full name of each student to string array.
     * @return information about all students.
     */
    public String[] getInfoAboutStudents() {
        String error[] = {"Cписок пуст"};
        if (listOfStudents.isEmpty()) return error;
        int i = 0;
        String[] tempStr = new String[listOfStudents.size()];
        for (AbstractStudent it : listOfStudents) {
            tempStr[i] = it.getFullName();
            i++;
        }
        return tempStr;
    }

    /**
     * This method add full name of each teacher to string array.
     * @return information about all teachers.
     */
    public String[] getInfoAboutTeachers() {
        String error[] = {"Cписок пуст"};
        if (listOfTeachers.isEmpty()) return error;
        int i = 0;
        String[] tempStr = new String[listOfTeachers.size()];
        for (Teacher it : listOfTeachers) {
            tempStr[i] = it.getFullName();
            i++;
        }
        return tempStr;
    }

    /**
     * This method add topic of each class to string array.
     * @return information about all classes.
     */
    public String[] getInfoAboutClasses() {
        String error[] = {"Cписок пуст"};
        if (listOfClasses.isEmpty()) return error;
        int i = 0;
        String[] tempStr = new String[listOfClasses.size()];
        for (AbstractClasses it : listOfClasses) {
            Lecture lectureTemp = Lecture.class.cast(listOfClasses.get(i));
            tempStr[i] = lectureTemp.topic;
            i++;
        }
        return tempStr;
    }

    /**
     * The method is used to search student at list of students.
     * @param infoForSearch full mame of the student.
     * @return "true" if student was found and "false" if didn't find.
     */
    public boolean searchStudentBoolean(String infoForSearch) {
        for (AbstractStudent it : listOfStudents) {
            if (it.getFullName().equals(infoForSearch) && it.getClass() == Student.class) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method is used to search starosta at list of students.
     * @param infoForSearch full name of starosta.
     * @return "true" if starosta was found and "false" if didn't find.
     */
    public boolean searchStarostaBoolean(String infoForSearch) {
        for (AbstractStudent it : listOfStudents) {
            if (it.getFullName().equals(infoForSearch) && it.getClass() == Starosta.class) {
                return true;
            }
        }
        return false;
    }

    /**
     * The method is used to search teacher at list of teachers.
     * @param infoForSearch full name of teacher.
     * @return "true" if teacher was found and "false" if didn't find.
     */
    public boolean searchTeacherBoolean(String infoForSearch) {
        for (Teacher it : listOfTeachers) {
            if (it.getFullName().equals(infoForSearch)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method helps to search teacher at list of teachers.
     * @param infoForSearch full name of teacher.
     * @return the object of class "Teacher" or null.
     */
    public Teacher searchTeacher(String infoForSearch) {
        for (Teacher it : listOfTeachers) {
            if (it.getFullName().equals(infoForSearch)) {
                return it;
            }
        }
        return null;
    }

    /**
     * This method helps to search student at list of students.
     * @param infoForSearch full name of student.
     * @return the object of class "Student" or null.
     */
    public Student searchStudent(String infoForSearch) {
        for (AbstractStudent it : listOfStudents) {
            if (it.getFullName().equals(infoForSearch) && it.getClass() == Student.class) {
                return Student.class.cast(it);
            }
        }
        return null;
    }

    /**
     * This method helps to search starosta at list of students.
     * @param infoForSearch full name of starosta.
     * @return the object of class "Starosta" or null.
     */
    public Starosta searchStarosta(String infoForSearch) {
        for (AbstractStudent it : listOfStudents) {
            if (it.getFullName().equals(infoForSearch) && it.getClass() == Starosta.class) {
                return Starosta.class.cast(it);
            }
        }
        return null;
    }

}
