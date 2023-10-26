package org.example;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends Frame {
    private JButton startButton = new JButton(new ImageIcon(Main.class.getResource(LINK+"Main_/startButton .png")));
    private JButton ExButton = new JButton(new ImageIcon(Main.class.getResource(LINK+"Main_/ExButton.png")));
    private JButton rankButton = new JButton(new ImageIcon(Main.class.getResource(LINK+"Main_/rankButton.png")));
    private JButton logOutButton = new JButton(new ImageIcon(Main.class.getResource(LINK+"Main_/logOutButton.png")));
    public Main(){
        int btn_width = 225;
        int btn_height = 75;
        background=new JLabel(new ImageIcon(Main.class.getResource("/static/db/img/Main_/back_main.png")));//배경이미지
        background.setBounds(0, 0, WIDTH, HEIGHT);
        add(background);


        startButton.setBounds(WIDTH / 2 - btn_width / 2, HEIGHT - 63 - 13 - (btn_height * 3), btn_width , btn_height);
        background.add(startButton);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new gameStart();
                setVisible(false);
            }
        });

        ExButton.setBounds(WIDTH / 2 - btn_width / 2, HEIGHT - 63  - (btn_height * 2), btn_width , btn_height);
        background.add(ExButton);
        ExButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ExampleGame();
                setVisible(false);
            }
        });

        rankButton.setBounds(40 , HEIGHT - (90 + btn_height), btn_width , btn_height);
        background.add(rankButton);
        rankButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Rank();
                setVisible(false);
            }
        });

        logOutButton.setBounds(WIDTH - 60 - btn_width , HEIGHT - (90 + btn_height), btn_width , btn_height);
        background.add(logOutButton);
        logOutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new login();
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new Main();
    }
}