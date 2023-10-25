package org.example;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gameStart extends Frame{
    public static void main(String[] args){}
    public gameStart(){

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
                    System.out.println("클릭");
                }
            });

            add(imageButton);
        }
    }
}

