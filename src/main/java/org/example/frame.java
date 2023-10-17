package org.example;
import javax.swing.JFrame;

public class frame extends JFrame{
    public frame(){
        int frame_width = 1080;
        int frame_height = 720;

        setTitle("원시 초밥");
        setSize(frame_width, frame_height);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}