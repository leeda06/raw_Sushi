package org.example;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class login extends Frame {
    private JTextField iDTextInput = new JTextField(20);
    private JTextField pWTextInput = new JTextField(20);

    private ArrayList<String> idList = new ArrayList<>();
    private ArrayList<String> pwList = new ArrayList<>();
    private String DATABASE_FILE = "user_database.txt";

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
                if (authenticate(idText, pwText)) {
                    // 로그인 성공 처리
                    JOptionPane.showMessageDialog(null, "로그인 성공");
                    Frame.ID = idText;
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
                if (addUser(idText, pwText)) {
                    JOptionPane.showMessageDialog(null, "회원가입 완료");
                } else {
                    JOptionPane.showMessageDialog(null, "회원가입 실패\n원인 : 중복 아이디");
                }
            }
        });
        add(pWButton);
    }

    private boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean addUser(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(DATABASE_FILE))) {
            String line;

            // 파일의 각 줄에 대해 반복
            while ((line = br.readLine()) != null) {
                // 각 줄을 쉼표로 분리하여 첫 번째 아이디를 추출
                String[] tokens = line.split(",");
                String firstId = tokens[0];

                // idList에 추가
                idList.add(firstId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE, true))) {
            if (idList.contains(username)) {
                return false; // 이미 존재하는 아이디
            } else {
                writer.write(username + "," + password);
                writer.newLine();
                idList.add(username);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        new login();
    }
}