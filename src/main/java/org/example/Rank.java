package org.example;import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Rank extends JFrame {
    public static void main(String[] args) {
        new Rank();
    }
    private JButton startButton = new JButton(new ImageIcon(Main.class.getResource("/static/db/img/Main_/startButton .png")));
    private JButton startButton2 = new JButton(new ImageIcon(Main.class.getResource("/static/db/img/Main_/startButton .png")));
    public Rank() {
        JPanel padding = new JPanel();
        padding.setLayout(new GridLayout(2, 1)); // 2개의 행, 1개의 열을 가지는 GridLayout
        padding.setPreferredSize(new Dimension(100, 100));
        padding.setBackground(Color.BLACK);

        startButton.setBounds(30,30,40,40);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Main();
                setVisible(false);
            }
        });
        add(startButton);

        startButton2.setBounds(Frame.WIDTH/2 - 520 / 2,100/2 - 30  ,520,70);
        add(startButton2);

        JPanel scrollablePanel = new JPanel();
        scrollablePanel.setLayout(new GridLayout(0, 1)); // 왼쪽에서 오른쪽으로 배치
        scrollablePanel.setBackground(Color.BLACK); // 배경색을 검정으로

        scrollablePanel.add(padding);
        for (int i = 1; i <= 100; i++) { // 100개의 아이템을 추가하여 스크롤이 필요하도록 함
            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(70, 100)); // 100x30 크기로 설정
            panel.setBackground(Color.WHITE);
            panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createCompoundBorder(),
                    new LineBorder(Color.BLACK, 10)// 검정
            ));


            scrollablePanel.add(panel);
        }
        JPanel padding2 = new JPanel();
        padding2.setPreferredSize(new Dimension(100, 30)); // 100x30 크기로 설정
        padding2.setBackground(Color.BLACK);
        scrollablePanel.add(padding2);

        // 스크롤 가능한 패널을 JScrollPane에 넣습니다.
        JScrollPane scrollPane = new JScrollPane(scrollablePanel);

        // JScrollPane을 프레임에 추가
        add(scrollPane);

        setSize(Frame.WIDTH, Frame.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫을 때 프로그램 종료
        setTitle("원시초밥");
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

