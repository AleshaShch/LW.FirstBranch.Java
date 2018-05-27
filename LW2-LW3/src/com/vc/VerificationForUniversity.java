package com.vc;

import com.model.University;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

/**
 * The class helps to describe the view - control part of MVC architecture pattern of university's verification window.
 */
public class VerificationForUniversity {
    private final char password[] = {'1'};
    private University university;

    VerificationForUniversity(University university) {
        this.university = university;

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

        JLabel jlab = new JLabel("Введите пароль");
        jlab.setHorizontalAlignment(SwingConstants.CENTER);
        jpnl.add(jlab, BorderLayout.NORTH);

        JPasswordField verFld = new JPasswordField();
        jpnl.add(verFld, BorderLayout.CENTER);
        verFld.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (Arrays.equals(verFld.getPassword(), password) && e.getKeyCode() == KeyEvent.VK_ENTER) {
                    verJDialog1.dispose();
                    new UniversityVC(university);
                }
            }
        });

        verJDialog1.setVisible(true);
    }

}
