package com.vc;

import com.model.Lecture;
import com.model.Student;
import com.model.University;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 * The class helps to describe the view - control part of MVC architecture part of student's main window.
 */
public class StudentVC {
    private University university;
    private Student student;

    StudentVC(University tempUniversity, Student tempStudent) {
        this.university = tempUniversity;
        this.student = tempStudent;

        JDialog jDialogS = new JDialog();
        jDialogS.setTitle(student.getFullName());
        jDialogS.setSize(300, 290);
        jDialogS.setLocationRelativeTo(null);
        jDialogS.setResizable(false);

        JPanel jPnl = new JPanel();
        jDialogS.add(jPnl);

        String[] tempForData = university.getInfoAboutClasses();
        String emptyString = "Cписок пуст";

        DefaultListModel lstMdl = new DefaultListModel();
        JList<String> jLst = new JList<String>(lstMdl);
        jLst.setSelectionMode(SINGLE_SELECTION);
        JScrollPane jScrllP = new JScrollPane(jLst);
        jScrllP.setPreferredSize(new Dimension(200, 200));
        jPnl.add(jScrllP);

        for (int i = 0; i < tempForData.length; i++)
            lstMdl.addElement(tempForData[i]);

        JButton jBttn = new JButton("Посетить лекцию");
        jPnl.add(jBttn);
        JLabel jLbl = new JLabel();
        jPnl.add(jLbl);

        jBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!lstMdl.isEmpty() && !jLst.isSelectionEmpty()) {
                    Lecture tempLecture = new Lecture(jLst.getSelectedValue());
                    student.attendLecture(tempLecture);
                    lstMdl.removeElementAt(jLst.getSelectedIndex());
                    jLst.clearSelection();
                }
            }
        });

        jDialogS.setVisible(true);
    }

}
