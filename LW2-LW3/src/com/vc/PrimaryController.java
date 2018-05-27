package com.vc;

import com.model.Journal;
import com.model.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to describe the view - control part of MVC architecture pattern of main window.
 */
public class PrimaryController {
    private final University university;

    PrimaryController(University university) {
        this.university = university;

        Journal journal = new Journal();
        university.setJournal(journal);

        JFrame primaryJfrm = new JFrame("University");
        primaryJfrm.setSize(450, 150);
        primaryJfrm.setLocationRelativeTo(null);
        primaryJfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        primaryJfrm.setResizable(false);

        JPanel jpnl = new JPanel();
        primaryJfrm.add(jpnl);
        FlowLayout flwLayout = new FlowLayout();
        flwLayout.setVgap(15);
        jpnl.setLayout(flwLayout);

        JLabel jlab = new JLabel("Доброго времени суток. Пожалуйста, представьтесь системе.");
        jlab.setHorizontalAlignment(SwingConstants.CENTER);
        jpnl.add(jlab);

        JRadioButton rBttn1 = new JRadioButton("Университет");
        jpnl.add(rBttn1);
        JRadioButton rBttn2 = new JRadioButton("Преподаватель");
        jpnl.add(rBttn2);
        JRadioButton rBttn3 = new JRadioButton("Студент");
        jpnl.add(rBttn3);
        JRadioButton rBttn4 = new JRadioButton("Староста");
        jpnl.add(rBttn4);
        ButtonGroup rBttnGroup = new ButtonGroup();
        rBttnGroup.add(rBttn1);
        rBttnGroup.add(rBttn2);
        rBttnGroup.add(rBttn3);
        rBttnGroup.add(rBttn4);
        JButton jBttn = new JButton("Продолжить");
        jpnl.add(jBttn);

        jBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rBttn1.isSelected()) new VerificationForUniversity(university);
                if (rBttn2.isSelected()) new VerificationForTeacher(university);
                if (rBttn3.isSelected()) new VerificationForStudent(university);
                if (rBttn4.isSelected()) new VerificationForStarosta(university);
            }
        });

        primaryJfrm.setVisible(true);
    }

}
