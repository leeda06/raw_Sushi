package org.example;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends Frame {
    private JButton startButton = new JButton(new ImageIcon(Main.class.getResource("/static/db/img/Main_/startButton .png")));
    private JButton ExButton = new JButton(new ImageIcon(Main.class.getResource("/static/db/img/Main_/ExButton.png")));
    private JButton rankButton = new JButton(new ImageIcon(Main.class.getResource("/static/db/img/Main_/rankButton.png")));
    private JButton logOutButton = new JButton(new ImageIcon(Main.class.getResource("/static/db/img/Main_/logOutButton.png")));
    public Main(){
        int btn_width = 225;
        int btn_height = 75;
        background=new JLabel(new ImageIcon(Main.class.getResource("/static/db/img/Main_/back_main.png")));//배경이미지
        background.setBounds(0, 0, Frame.WIDTH, Frame.HEIGHT);
        add(background);


        startButton.setBounds(Frame.WIDTH / 2 - btn_width / 2, Frame.HEIGHT - 63 - 13 - (btn_height * 3), btn_width , btn_height);
        background.add(startButton);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new GameStart();
                setVisible(false);
            }
        });

        ExButton.setBounds(Frame.WIDTH / 2 - btn_width / 2, Frame.HEIGHT - 63  - (btn_height * 2), btn_width , btn_height);
        background.add(ExButton);
        ExButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new ExampleGame();
                setVisible(false);
            }
        });

        rankButton.setBounds(40 , Frame.HEIGHT - (90 + btn_height), btn_width , btn_height);
        background.add(rankButton);
        rankButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Rank();
                setVisible(false);
            }
        });

        logOutButton.setBounds(Frame.WIDTH - 60 - btn_width , Frame.HEIGHT - (90 + btn_height), btn_width , btn_height);
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