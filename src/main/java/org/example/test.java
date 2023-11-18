package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends Frame{
    private JLabel imageLabel;

    public test() {
        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);

        JButton displayButton = new JButton("이미지 표시");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayImage();
            }
        });
        add(displayButton, BorderLayout.SOUTH);

    }
    private void displayImage() {
        ImageIcon icon = new ImageIcon("image1.jpg"); // 이미지 파일의 경로
        imageLabel.setIcon(icon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                test gui = new test();
                gui.setVisible(true);
            }
        });
    }

}
