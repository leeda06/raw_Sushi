package org.example;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

public class main extends frame {
    public main(){

        Color frameColor = new Color(200, 180, 230);
        getContentPane().setBackground(frameColor);

        int btn_width = 450;
        int btn_height = 150;

        JButton Startbutton = new JButton("버튼 1");
        Startbutton.setBounds((1080 / 2) - (btn_width / 4), 720 - btn_height - (80 * 2) , btn_width / 2, btn_height / 2);
        Startbutton.setBackground(Color.WHITE);
        add(Startbutton);

        Startbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new gameStart();
                setVisible(false); // 창 안보이게 하기
            }
        });


        JButton button = new JButton("버튼 2");
        button.setBounds((1080 / 2) - (btn_width / 4), 720 - btn_height -(80 * 1), btn_width / 2, btn_height / 2);
        button.setBackground(Color.WHITE);
        add(button);

        int rank_btn_width = 360;
        int rank_btn_height = 130;

        JButton rank_btn = new JButton("랭킹 버튼");
        rank_btn.setBounds(50, 720 - btn_height - 50 , rank_btn_width / 2, rank_btn_height / 2);
        rank_btn.setBackground(Color.WHITE);
        add(rank_btn);

    }
    public static void main(String[] args) {
        main frame = new main();
    }
}