package org.example;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;



public class login extends Frame{
    private JTextField iDTextInput = new JTextField(20);
    private JTextField pWTextInput = new JTextField(20);

    private ArrayList<String> idList = new ArrayList<>();
    private ArrayList<String> pwList = new ArrayList<>();
    public login(){

        getContentPane().setBackground(Color.ORANGE);

        iDTextInput.setBounds((Frame.WIDTH - 450) / 2 , Frame.HEIGHT - 139 - (70 + (93*3)), 450, 70);
        pWTextInput.setBounds((Frame.WIDTH - 450) / 2 , Frame.HEIGHT - 139 - (93*2)- 20, 450, 70);

        Font newFont = new Font("나눔체", Font.PLAIN, 30); // 여기에서 "Arial"은 원하는 폰트 이름이며, 20은 원하는 크기입니다.
        iDTextInput.setFont(newFont);
        pWTextInput.setFont(newFont);

        add(iDTextInput);
        add(pWTextInput);

        JLabel iDText = new JLabel("아이디");
        JLabel pWText = new JLabel("비밀번호");

        iDText.setBounds(((Frame.WIDTH - 450) / 2 ),(Frame.HEIGHT - 139 - (70 + (93*4))-140) , 500, 400);
        pWText.setBounds(((Frame.WIDTH - 450) / 2 ),(Frame.HEIGHT - 139 - (70 + (93*3))-90) , 500, 400);

        iDText.setFont(newFont);
        pWText.setFont(newFont);

        add(iDText);
        add(pWText);

        JButton iDButton = new JButton("로그인");
        iDButton.setBounds((Frame.WIDTH/2) - 225, Frame.HEIGHT - 230, 220, 70);
        iDButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String idText = iDTextInput.getText();
                String pwText = pWTextInput.getText();
                if (idList.contains(idText) && pwList.contains(pwText)) {
                    // 로그인 성공 처리
                    JOptionPane.showMessageDialog(null, "로그인 성공");
                    new Main();
                    setVisible(false);
                } else {
                    // 로그인 실패 처리
                    JOptionPane.showMessageDialog(null, "로그인 실패");
                }
            }
        });
        add(iDButton);

        JButton pWButton = new JButton("회원가입");
        pWButton.setBounds((Frame.WIDTH/2) + 5, Frame.HEIGHT - 230, 220, 70);
        pWButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String idText = iDTextInput.getText();
                String pwText = pWTextInput.getText();
//                if(idList.size() != -1 && pwList.size() != -1 && ((idList.contains(idText) && pwList.contains(pwText)) == false)){
//                    JOptionPane.showMessageDialog(null, "회원가입 실패\n원인 : 중복");
//                }else{
                    idList.add(idText);
                    pwList.add(pwText);
                    JOptionPane.showMessageDialog(null, "회원가입 완료");
//                }
            }
        });
        add(pWButton);
    }

    public static void main(String []args){
        new login();
    }
}
