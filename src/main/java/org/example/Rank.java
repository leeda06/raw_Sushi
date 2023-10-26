package org.example;import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Rank extends JFrame {
    public static void main(String[] args) {
        new Rank();
    }
    private Color backColor = Color.ORANGE;
    // 이미지 버튼에 사용될
    private JButton nextButton = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"Rank_/nextButton.png")));
    private JButton startButton2 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"Rank_/titleButton.png")));
    private ImageIcon imageIcon = new ImageIcon(Main.class.getResource(Frame.LINK+"Rank_/coin.png"));
    public Rank() {
        JPanel padding = new JPanel();
        padding.setLayout(new GridLayout(2, 1)); // 2개의 행, 1개의 열을 가지는 GridLayout
        padding.setPreferredSize(new Dimension(100, 100));
        padding.setBackground(backColor);

        nextButton.setBounds(100/2 - 30 , 100/2 - 30,70,70);
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Main();
                setVisible(false);
            }
        });
        add(nextButton);

        startButton2.setBounds(Frame.WIDTH/2 - 520 / 2,100/2 - 30  ,520,70);
        startButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Rank();
                setVisible(false);
            }
        });
        add(startButton2);

        JPanel scrollablePanel = new JPanel();
        scrollablePanel.setLayout(new GridLayout(0, 1)); // 왼쪽에서 오른쪽으로 배치
        scrollablePanel.setBackground(backColor); // 배경색을 검정으로

        scrollablePanel.add(padding);
        for (int i = 1; i <= 30; i++) { // 100개의 아이템을 추가하여 스크롤이 필요하도록 함

            JPanel panel = new JPanel();
            panel.setPreferredSize(new Dimension(100, 100));
            panel.setBackground(Color.WHITE);
            JPanel rightPanel = new JPanel();
            rightPanel.setPreferredSize(new Dimension(250, 100));
            rightPanel.setBackground(Color.WHITE);

        // JPanel 내부에 컴포넌트를 추가하기 위한 BorderLayout 사용
            panel.setLayout(new BorderLayout());
            String number = Integer.toString(i);
            // 서브 패널을 생성하고 서브 패널 내부에 번호와 왼쪽 텍스트를 배치
            JLabel numberLabel = new JLabel(number);
            JLabel leftTextLabel = new JLabel("아이디" + number);
            JLabel rightTextLabel = new JLabel("점수" + number + 010000);
            JLabel imageLabel = new JLabel(imageIcon);

            Font labelFont = numberLabel.getFont();
            numberLabel.setFont(labelFont.deriveFont(30f));
            leftTextLabel.setFont(labelFont.deriveFont(30f));
            rightTextLabel.setFont(labelFont.deriveFont(30f));
            // JLabel 텍스트 가운데 정렬
            numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
            rightTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

            numberLabel.setPreferredSize(new Dimension(100, numberLabel.getPreferredSize().height));
            leftTextLabel.setPreferredSize(new Dimension(100, numberLabel.getPreferredSize().height));

            rightPanel.add(rightTextLabel, BorderLayout.CENTER);
            rightPanel.add(imageLabel, BorderLayout.EAST);

            panel.add(numberLabel,BorderLayout.WEST);
            panel.add(leftTextLabel, BorderLayout.CENTER);
            panel.add(rightPanel, BorderLayout.EAST);

            panel.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createCompoundBorder(),
                    new LineBorder(backColor, 10) // 검정색 테두리
            ));

            scrollablePanel.add(panel);
        }
        JPanel padding2 = new JPanel();
        padding2.setPreferredSize(new Dimension(100, 30)); // 100x30 크기로 설정
        padding2.setBackground(backColor);
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

