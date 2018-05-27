package com.vc;

import com.model.Lecture;
import com.model.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to describe view - control part of MVC architecture pattern of university's main window.
 */
public class UniversityVC {
    private University university;

    UniversityVC(University university) {
        this.university = university;

        JDialog jDialogU = new JDialog();
        jDialogU.setTitle("Университет");
        jDialogU.setSize(500, 500);
        jDialogU.setLocationRelativeTo(null);
        jDialogU.setResizable(false);

        JTabbedPane jtp = new JTabbedPane();
        jtp.addTab("Студенты", new StudentPanel(university));
        jtp.addTab("Преподаватели", new TeacherPanel(university));
        jtp.addTab("Занятия", new ClassesPanel(university));
        jDialogU.add(jtp);

        jDialogU.setVisible(true);
    }
}

class StudentPanel extends JPanel {
    private final University university;

    public StudentPanel(University university) {
        this.university = university;

        Box hBox = Box.createHorizontalBox();

        JTextField studentsFld = new JTextField(25);
        hBox.add(studentsFld);

        JButton addBttn = new JButton("Зачислить студента");
        hBox.add(addBttn);

        JCheckBox checkBoxForStarosta = new JCheckBox("Староста");
        hBox.add(checkBoxForStarosta);

        add(hBox);

        String[] tempForData = university.getInfoAboutStudents();
        String emptyString = "Cписок пуст";

        DefaultListModel lstModel = new DefaultListModel();
        JList<String> jLst = new JList<String>(lstModel);
        JScrollPane jScrllP = new JScrollPane(jLst);
        for (int i = 0; i < tempForData.length; i++)
            lstModel.addElement(tempForData[i]);

        jScrllP.setPreferredSize(new Dimension(300, 390));
        add(jScrllP);

        addBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstModel.firstElement() == emptyString) lstModel.set(0, studentsFld.getText());
                else lstModel.addElement(studentsFld.getText());
                if (checkBoxForStarosta.isSelected()) {
                    university.enrollStarosta(studentsFld.getText());
                    checkBoxForStarosta.setSelected(false);
                    checkBoxForStarosta.setEnabled(false);
                } else university.enrollStudent(studentsFld.getText());
                studentsFld.setText(" ");
            }
        });
        setVisible(true);
    }
}

class TeacherPanel extends JPanel {
    private final University university;

    public TeacherPanel(University university) {
        this.university = university;

        Box hBox = Box.createHorizontalBox();

        JTextField teachersFld = new JTextField(25);
        hBox.add(teachersFld);

        JButton addBttn = new JButton("Нанять преподавателя");
        hBox.add(addBttn);

        add(hBox);

        String[] tempForData = university.getInfoAboutTeachers();
        String emptyString = "Cписок пуст";

        DefaultListModel lstModel = new DefaultListModel();
        JList<String> jLst = new JList<String>(lstModel);
        JScrollPane jScrllP = new JScrollPane(jLst);
        for (int i = 0; i < tempForData.length; i++)
            lstModel.addElement(tempForData[i]);
        jScrllP.setPreferredSize(new Dimension(300, 390));
        add(jScrllP);

        addBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstModel.contains(emptyString)) lstModel.set(0, teachersFld.getText());
                else lstModel.addElement(teachersFld.getText());
                university.employTeacher(teachersFld.getText());
                teachersFld.setText(" ");
            }
        });

        setVisible(true);
    }
}

class ClassesPanel extends JPanel {
    private final University university;

    public ClassesPanel(University university) {
        this.university = university;

        Box hBox = Box.createHorizontalBox();

        JTextField classesFld = new JTextField(25);
        hBox.add(classesFld);

        JButton addBttn = new JButton("Добавить лекцию");
        hBox.add(addBttn);

        add(hBox);

        String[] tempForData = university.getInfoAboutClasses();
        String emptyString = "Cписок пуст";

        DefaultListModel lstModel = new DefaultListModel();
        JList<String> jLst = new JList<String>(lstModel);
        for (int i = 0; i < tempForData.length; i++)
            lstModel.addElement(tempForData[i]);
        JScrollPane jScrllP = new JScrollPane(jLst);
        jScrllP.setPreferredSize(new Dimension(300, 390));
        add(jScrllP);

        addBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lstModel.contains(emptyString)) lstModel.set(0, classesFld.getText());
                else lstModel.addElement(classesFld.getText());
                university.listOfClasses.add(new Lecture(classesFld.getText()));
                classesFld.setText(" ");
            }
        });

        setVisible(true);
    }
}