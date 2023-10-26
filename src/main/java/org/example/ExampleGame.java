package org.example;

import javax.swing.*;
import java.awt.*;

public class ExampleGame extends Frame{
    public ExampleGame(){
        background = new JLabel(new ImageIcon(Main.class.getResource(Frame.LINK+"Main_/back_main.png")));
        background.setBounds(0 , 0 , Frame.WIDTH, Frame.HEIGHT);
        add(background);
    }

    public static void main(String[] args) {
        new ExampleGame();
    }
}