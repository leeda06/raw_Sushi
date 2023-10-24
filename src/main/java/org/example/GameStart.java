package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameStart extends Frame {
    private Image screenImage;
    private Graphics screenGraphics;
    private Image background;//배경이미지

    public GameStart(){
        background=new ImageIcon(GameStart.class.getResource("/static/db/img/back_main.png")).getImage();//배경이미지

        setTitle("원시 초밥");
        Color frameColor = new Color(200, 180, 230);
        getContentPane().setBackground(frameColor);

        int btn_width = 450;
        int btn_height = 150;

        JButton Startbutton = new JButton("버튼 1");
        Startbutton.setBounds((Frame.WIDTH / 2) - (btn_width / 4), Frame.HEIGHT - btn_height - (80 * 2) , btn_width / 2, btn_height / 2);
        Startbutton.setBackground(Color.WHITE);
        add(Startbutton);

        Startbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GameStart();
                setVisible(false);
            }
        });


        JButton button = new JButton("버튼 2");
        button.setBounds((Frame.WIDTH / 2) - (btn_width / 4), Frame.HEIGHT - btn_height - (80), btn_width / 2, btn_height / 2);
        button.setBackground(Color.WHITE);
        add(button);

        int rank_btn_width = 360;
        int rank_btn_height = 130;

        JButton rank_btn = new JButton("랭킹 버튼");
        rank_btn.setBounds(50, Frame.HEIGHT - btn_height - 50 , rank_btn_width / 2, rank_btn_height / 2);
        rank_btn.setBackground(Color.WHITE);
        add(rank_btn);

    }
    public void paint(Graphics g) {//그리는 함수
        screenImage = createImage(Frame.WIDTH, Frame.HEIGHT);
        screenGraphics = screenImage.getGraphics();
        screenDraw(screenGraphics);
        g.drawImage(screenImage, 0, 0, null);//background를 그려줌
    }

    private void screenDraw(Graphics g) {
        g.drawImage(background, 0, 0,null);
        this.repaint();
    }

    public static void main(String[] args) {
        GameStart frame = new GameStart();
    }
}