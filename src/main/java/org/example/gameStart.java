package org.example;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameStart extends Frame{
    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        gameStart frame = new gameStart();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new FlowLayout());

        String[] imagePaths = {
                "image1.jpg",
                "image2.jpg",
                "image3.jpg",
                "image4.jpg",
                "image5.jpg"
        };

        for (String imagePath : imagePaths) {
            ImageIcon icon = new ImageIcon(imagePath);

            JButton imageButton = new JButton(icon);

            imageButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(frame, "이미지 버튼 클릭됨");
                }
            });

            frame.add(imageButton);
        }

        frame.setVisible(true);
    }
}

