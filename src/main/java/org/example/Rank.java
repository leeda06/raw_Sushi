package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rank extends JFrame {
    private Color backColor = Color.ORANGE;
    private JButton nextButton = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK + "Rank_/nextButton.png")));
    private JButton startButton2 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK + "Rank_/titleButton.png")));
    private ImageIcon imageIcon = new ImageIcon(Main.class.getResource(Frame.LINK + "Rank_/coin.png"));
    private int count = 0;

    public Rank() {
        JPanel padding = new JPanel();
        padding.setLayout(null);
        padding.setPreferredSize(new Dimension(100, 100));
        padding.setBackground(backColor);

        nextButton.setBounds(100 / 2 - 30, 100 / 2 - 30, 70, 70);
        nextButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Main();
                setVisible(false);
            }
        });
        padding.add(nextButton);

        startButton2.setBounds(Frame.WIDTH / 2 - 520 / 2, 100 / 2 - 30, 520, 70);
        startButton2.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new Rank();
                setVisible (false);
            }
        });
        padding.add(startButton2);

        JPanel scrollablePanel = new JPanel();
        scrollablePanel.setLayout(new GridLayout(0, 1));
        scrollablePanel.setBackground(backColor);

        scrollablePanel.add(padding);

        try (BufferedReader reader = new BufferedReader(new FileReader("user_database.txt"))) {
            String line;
            ArrayList<UserData> userDataList = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String username = parts[0];
                    int score = Integer.parseInt(parts[2]);

                    userDataList.add(new UserData(username, score));
                }
            }

            // Sort the user data list
            Collections.sort(userDataList);

            int maxUsernameLength = getMaxStringLength(userDataList);
            int previousScore = -1; // 이전 아이디의 점수를 저장할 변수
            int rank = 0; // 순위를 저장할 변수

            for (int i = 0; i < userDataList.size(); i++) {
                UserData userData = userDataList.get(i);
                int currentScore = userData.getScore();

                if (currentScore != previousScore) {
                    // 현재 아이디의 점수가 이전 아이디의 점수와 다를 경우 순위를 증가시킴
                    rank++;
                }

                JPanel panel = createRankPanel(userData.getUsername(), String.valueOf(currentScore), maxUsernameLength, rank);
                scrollablePanel.add(panel);

                previousScore = currentScore; // 이전 아이디의 점수 업데이트
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel padding2 = new JPanel();
        padding2.setPreferredSize(new Dimension(100, 30));
        padding2.setBackground(backColor);
        scrollablePanel.add(padding2);

        JScrollPane scrollPane = new JScrollPane(scrollablePanel);

        add(scrollPane);

        setSize(Frame.WIDTH, Frame.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("원시초밥");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createRankPanel(String username, String score, int maxUsernameLength, int rank) {
        count++;
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setBackground(Color.WHITE);
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(250, 100));
        rightPanel.setBackground(Color.WHITE);

        panel.setLayout(new BorderLayout());

        JLabel numberLabel = new JLabel(Integer.toString(rank)); // 순위 출력
        JLabel leftTextLabel = new JLabel(username);
        JLabel rightTextLabel = new JLabel(score);
        JLabel imageLabel = new JLabel(imageIcon);

        Font labelFont = numberLabel.getFont();
        numberLabel.setFont(labelFont.deriveFont(30f));
        leftTextLabel.setFont(labelFont.deriveFont(30f));
        rightTextLabel.setFont(labelFont.deriveFont(30f));

        numberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rightTextLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        numberLabel.setPreferredSize(new Dimension(100, numberLabel.getPreferredSize().height));

        int leftLabelWidth = 30 + maxUsernameLength * 15;
        leftTextLabel.setPreferredSize(new Dimension(leftLabelWidth, numberLabel.getPreferredSize().height));

        rightPanel.add(rightTextLabel, BorderLayout.CENTER);
        rightPanel.add(imageLabel, BorderLayout.EAST);

        panel.add(numberLabel, BorderLayout.WEST);
        panel.add(leftTextLabel, BorderLayout.CENTER);
        panel.add(rightPanel, BorderLayout.EAST);

        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(),
                new LineBorder(backColor, 10)
        ));

        return panel;
    }

    private int getMaxStringLength(List<UserData> userDataList) {
        int maxLength = 0;
        for (UserData userData : userDataList) {
            String username = userData.getUsername();
            if (username.length() > maxLength) {
                maxLength = username.length();
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        new Rank();
    }

    // UserData class
    private static class UserData implements Comparable<UserData> {
        private String username;
        private int score;

        public UserData(String username, int score) {
            this.username = username;
            this.score = score;
        }

        public String getUsername() {
            return username;
        }

        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(UserData other) {
            // Compare by score in descending order
            return Integer.compare(other.getScore(), this.score);
        }
    }
}
