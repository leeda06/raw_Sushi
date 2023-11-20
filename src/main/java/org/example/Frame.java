package org.example;
import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;
    public static final String LINK = "/static/db/img/";
    public static String ID = "";
    public static int SCORE = 0;
    public static int TEMA = -1;
    public static int ITEM = 0;
    public static int COUNT = 5;
    public static String DDAY = "";
    public static int GameDay = 0;
    Image screenImage;
    Graphics screenGraphics;
    JLabel background;

    public Frame() {
        setSize(WIDTH, HEIGHT); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료
        setTitle("원시초밥");
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);   // 창보이게
        background=null;//배경이미지
    }

    public void paint(Graphics g) {//그리는 함수
        screenImage = createImage(Frame.WIDTH, Frame.HEIGHT);
        screenGraphics = screenImage.getGraphics();
        screenDraw(screenGraphics);
        g.drawImage(screenImage, 0, 0, null);//background를 그려줌
    }

    public void screenDraw(Graphics g) {
        paintComponents(g);
        this.repaint();
    }

    public static void main(String[] args) {
        Frame fr = new Frame();
    }
}