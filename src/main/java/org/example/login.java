package org.example;

import java.awt.*;
import java.util.Scanner;
import javax.swing.*;



public class login extends Frame{
    public login(){

        JButton iDButton = new JButton("로그인");
        JButton passWordButton = new JButton("회원가입");

        iDButton.setBounds((Frame.WIDTH - 450) / 2 , Frame.HEIGHT - 139 - (70 + (93*3)), 450, 70);
        passWordButton.setBounds((Frame.WIDTH - 450) / 2 , Frame.HEIGHT - 139 - (70 + (93*(3 /2))), 450, 70);

        add(iDButton);
        add(passWordButton);
    }

    public static void main(String []args){
        new login();
    }
}
