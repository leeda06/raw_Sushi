package org.example;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;



public class login extends Frame{
    public login(){

    }

    public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        JFrame frame = new JFrame("로그인 화면");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        JPanel panel1 = new JPanel();

        JButton button1 = new JButton("로그인");
        JButton button2 = new JButton("회원가입");

        button1.setBounds(200, 50, 100, 30);
        button2.setBounds(200, 50, 100, 30);

        panel1.add(button1);
        panel1.add(button2);

        frame.add(panel1);

        // 화면 중앙에 창 뜨게
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - frame.getWidth()) / 2;
        int y = (dim.height - frame.getHeight()) / 2;
        frame.setLocation(x, y);


        frame.setVisible(true);
    }
}
