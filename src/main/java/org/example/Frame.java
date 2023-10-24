package org.example;
import javax.swing.JFrame;

public class Frame extends JFrame{
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;

    public Frame() {
        setSize(1080, 720); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료
        setTitle("원시초밥");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        Frame fr = new Frame();
    }
}