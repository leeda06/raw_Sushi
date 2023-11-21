package org.example;


import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main extends Frame {
    private JButton startButton = new JButton(new ImageIcon(Main.class.getResource(LINK+"Main_/startButton .png")));
    private JButton ExButton = new JButton(new ImageIcon(Main.class.getResource(LINK+"Main_/ExButton.png")));
    private JButton rankButton = new JButton(new ImageIcon(Main.class.getResource(LINK+"Main_/rankButton.png")));
    private JButton logOutButton = new JButton(new ImageIcon(Main.class.getResource(LINK+"Main_/logOutButton.png")));
   private  JButton partButton = new JButton("파티클 버튼");
   private  JButton rewordButton = new JButton("일일보상 버튼");

    public Main(){
        int btn_width = 225;
        int btn_height = 75;
        background=new JLabel(new ImageIcon(Main.class.getResource("/static/db/img/Main_/back_main.png")));
        background.setBounds(0, 0, WIDTH, HEIGHT);
        add(background);


        startButton.setBounds(WIDTH / 2 - btn_width / 2, HEIGHT - 63 - 13 - (btn_height * 3), btn_width , btn_height);
        background.add(startButton);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    IDCount("user_database.txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

                if(Frame.COUNT >= 0){
                    new Store();
                }else{
                    new Main();
                }
                setVisible(false);
            }
        });

        ExButton.setBounds(WIDTH / 2 - btn_width / 2, HEIGHT - 63  - (btn_height * 2), btn_width , btn_height);
        background.add(ExButton);
        ExButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Store();
                setVisible(false);
            }
        });

        rankButton.setBounds(40 , HEIGHT - (90 + btn_height), btn_width , btn_height);
        background.add(rankButton);
        rankButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Rank();
                setVisible(false);
            }
        });

        logOutButton.setBounds(WIDTH - 60 - btn_width , HEIGHT - (90 + btn_height), btn_width , btn_height);
        background.add(logOutButton);
        logOutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new login();
                setVisible(false);
            }
        });

        partButton.setBounds(WIDTH - 60 - btn_width , HEIGHT - (90 + btn_height * 3), btn_width , btn_height);
        background.add(partButton);
        partButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new FireworkSimulator();
//                setVisible(false);
            }
        });
        rewordButton.setBounds(40,40, btn_width , btn_height);
        background.add(rewordButton);
        rewordButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new DailyRewardApp().setVisible(true);
            }
        });
    }
    private static boolean IDCount(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] columns = line.split(",");

            // 가정: 각 열의 순서가 아이디, 비밀번호, 점수, 토핑 단계, 테마 번호, 날짜, 목숨 순서라고 가정
            String id = columns[0].trim(); // 아이디 추출

            if (id.equals(Frame.ID) && Integer.valueOf(columns[6]) > 0) {
                Frame.COUNT -= 1;
                columns[6] = String.valueOf(Frame.COUNT);
                // 변경된 열을 다시 문자열로 조합
                String updatedLine = String.join(",", columns);
                // 리스트에서 해당 라인을 업데이트
                lines.set(i, updatedLine);
                Files.write(path, lines, StandardCharsets.UTF_8);
                return true;
            }
        }
        Files.write(path, lines, StandardCharsets.UTF_8);
        return false;
    }
    public static void main(String[] args) {
        new Main();
    }
}