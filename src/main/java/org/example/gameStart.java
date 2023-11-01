package org.example;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class gameStart extends Frame{
    public gameStart() {
        JButton button1 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image1.jpg")));
        JButton button2 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image2.jpg")));
        JButton button3 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image3.jpg")));
        JButton button4 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image4.jpg")));
        JButton button5 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image5.jpg")));
        JButton button6 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image4.jpg")));
        JButton button7 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image5.jpg")));
        button1.setBounds(100, 350, 120, 120);
        getContentPane().add(button1);
        button1.setVisible(true);
        button2.setBounds(220, 350, 120, 120);
        getContentPane().add(button2);
        button2.setVisible(true);
        button3.setBounds(340, 350, 120, 120);
        getContentPane().add(button3);
        button3.setVisible(true);
        button4.setBounds(460, 350, 120, 120);
        getContentPane().add(button4);
        button4.setVisible(true);
        button5.setBounds(580, 350, 120, 120);
        getContentPane().add(button5);
        button5.setVisible(true);
        button6.setBounds(700, 350, 120, 120);
        getContentPane().add(button6);
        button6.setVisible(true);
        button7.setBounds(820, 350, 120, 120);
        getContentPane().add(button7);
        button7.setVisible(true);

        JButton arrow1 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/arrow1.jpg")));
        JButton arrow2 = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/arrow2.jpg")));
        arrow1.setBounds(20, 370, 80, 80);
        getContentPane().add(arrow1);
        arrow1.setVisible(true);
        arrow2.setBounds(940, 370, 80, 80);
        getContentPane().add(arrow2);
        arrow2.setVisible(true);

        JButton doma = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/doma.jpg")));
        doma.setBounds((Frame.WIDTH/2) - 130, Frame.HEIGHT - 230, 200, 137);
        getContentPane().add(doma);
        doma.setVisible(true);

        getContentPane().setBackground(Color.white);

    }

    public static void main(String[] args) {
        new gameStart();

    }

}

