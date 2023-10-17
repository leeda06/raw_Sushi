package org.example;

import javax.swing.*;
import java.awt.*;

public class main extends frame {
    public main(){
        Color frameColor = new Color(200, 180, 230);
        getContentPane().setBackground(frameColor);

        JButton Startbutton = new JButton("버튼 1");
        Startbutton.setBounds(1080/2 - 150, 720 - 350 , 300, 100);
        Startbutton.setBackground(Color.WHITE);
        add(Startbutton);

        JButton button1 = new JButton("버튼 2");
        button1.setBounds(1080/2 - 150, 720 - 200 , 300, 100);
        button1.setBackground(Color.WHITE);
        add(button1);

    }
    public static void main(String[] args) {
        main frame = new main();
    }
}