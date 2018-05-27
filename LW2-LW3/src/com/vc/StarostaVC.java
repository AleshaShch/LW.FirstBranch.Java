package com.vc;

import com.model.Lecture;
import com.model.Starosta;
import com.model.Student;
import com.model.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.ListSelectionModel.SINGLE_SELECTION;

/**
 * This class helps to describe the view - control part of MVC architecture pattern of starosta's main window.
 */
public class StarostaVC {
    private University university;
    private Starosta starosta;

    StarostaVC(University university, Starosta starosta) {
        this.university = university;
        this.starosta = starosta;

        JDialog jDialogS = new JDialog();
        jDialogS.setTitle(starosta.getFullName());
        jDialogS.setSize(500, 280);
        jDialogS.setLocationRelativeTo(null);
        jDialogS.setResizable(false);

        JPanel jPnl = new JPanel();
        jDialogS.add(jPnl);

        String[] tempForData1 = university.getInfoAboutClasses();
        String emptyString = "Cписок пуст";

        DefaultListModel lstMdl1 = new DefaultListModel();
        JList<String> jLst1 = new JList<String>(lstMdl1);
        jLst1.setSelectionMode(SINGLE_SELECTION);
        JScrollPane jScrllP1 = new JScrollPane(jLst1);

        for (int i = 0; i < tempForData1.length; i++)
            lstMdl1.addElement(tempForData1[i]);

        jScrllP1.setPreferredSize(new Dimension(200, 200));
        jPnl.add(jScrllP1);

        DefaultListModel lstMdl2 = new DefaultListModel();
        JList<String> jLst2 = new JList<String>(lstMdl2);
        jLst2.setSelectionMode(SINGLE_SELECTION);
        JScrollPane jScrllP2 = new JScrollPane(jLst2);

        jScrllP2.setPreferredSize(new Dimension(200, 200));
        jPnl.add(jScrllP2);

        JButton jBttn1 = new JButton("Посетить лекцию");
        jPnl.add(jBttn1);

        JButton jBttn2 = new JButton(" Присутсвующие ");
        jPnl.add(jBttn2);

        jBttn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!lstMdl1.isEmpty() && !jLst1.isSelectionEmpty()) {
                    Lecture lecture = new Lecture(jLst1.getSelectedValue());
                    starosta.attendLecture(lecture);
                    lstMdl1.removeElementAt(jLst1.getSelectedIndex());
                    jLst1.clearSelection();
                }
            }
        });

        jBttn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] tempForData2 = starosta.NoteAbsentStarosta();

                for (int i = 0; i < tempForData2.length; i++)
                    lstMdl2.addElement(tempForData2[i]);
            }
        });

        jDialogS.setVisible(true);
    }

}


