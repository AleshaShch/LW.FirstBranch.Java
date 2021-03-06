package com.vc;

import com.model.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class is used to describe the view - control part of MVC architecture pattern of student's verification window.
 */
public class VerificationForStudent {
    private final University university;

    VerificationForStudent(University tempUniversity) {
        this.university = tempUniversity;

        JDialog verJDialog1 = new JDialog();
        verJDialog1.setSize(100, 85);
        verJDialog1.setTitle("Верификация");
        verJDialog1.setLocationRelativeTo(null);
        verJDialog1.setResizable(false);

        JPanel jpnl = new JPanel();
        verJDialog1.add(jpnl);
        BorderLayout brdrLayout = new BorderLayout();
        jpnl.setLayout(brdrLayout);
        brdrLayout.setVgap(10);

        JLabel jlab = new JLabel("Введите имя и фамилию");
        jlab.setHorizontalAlignment(SwingConstants.CENTER);
        jpnl.add(jlab, BorderLayout.NORTH);

        JTextField jTxtFld = new JTextField(5);
        jpnl.add(jTxtFld, BorderLayout.CENTER);
        jTxtFld.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (university.searchStudentBoolean(jTxtFld.getText()) && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    new StudentVC(university, university.searchStudent(jTxtFld.getText()));
                    verJDialog1.dispose();
                }
            }
        });

        verJDialog1.setVisible(true);
    }

}
