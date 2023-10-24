package org.example;


import javax.swing.*;
import java.awt.*;

public class Main extends Frame {
    private Image screenImage;
    private Graphics screenGraphics;
    private Image background;

    public Main(){

        background=new ImageIcon(Main.class.getResource("/static/db/img/back_main.png")).getImage();//배경이미지
    }
    public void paint(Graphics g) {//그리는 함수
        screenImage = createImage(Frame.WIDTH, Frame.HEIGHT);
        screenGraphics = screenImage.getGraphics();
        screenDraw(screenGraphics);
        g.drawImage(screenImage, 0, 0, null);//background를 그려줌
    }

    private void screenDraw(Graphics g) {
        g.drawImage(background, 0 , 0 , null);
        this.repaint();
    }

    public static void main(String[] args) {
        Main frame = new Main();
    }
}