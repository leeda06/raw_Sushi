package org.example;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class DailyRewardProgram extends Frame {
    private String ID = "노경민5"; // 사용자 아이디
    private String DDAY = "2023-11-17"; // 마지막 출석일
    private int SCORE = 30; // 점수

    public DailyRewardProgram() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("일일 보상 프로그램");
        setSize(300, 200);
        setLayout(null);

        JButton claimRewardButton = new JButton("일일 보상 받기");
        claimRewardButton.setBounds(50, 50, 200, 50);
        claimRewardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                claimDailyReward();
            }
        });
        add(claimRewardButton);
    }

    private void claimDailyReward() {
        if (isEligibleForReward()) {
            // 보상을 받는 로직 추가
            JOptionPane.showMessageDialog(null, "보상을 받았습니다!");

            // 아이디가 1번째일 때 점수를 30 증가
            if ("1".equals(ID)) {
                increaseScore(30);
            }

            updateLastAttendanceDate(); // 출석일을 오늘로 업데이트
        } else {
            JOptionPane.showMessageDialog(null, "아직 보상을 받을 수 없습니다.");
        }
    }

    private void increaseScore(int amount) {
        SCORE += amount;
        updateScoreInFile();
    }

    private void updateScoreInFile() {
        try {
            File file = new File("user_database.txt");
            ArrayList<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts[0].equals(ID)) {
                        // 아이디가 1번째인 경우, 점수(3번째)를 업데이트
                        parts[2] = String.valueOf(SCORE);
                        line = String.join(",", parts);
                    }
                    lines.add(line);
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String line : lines) {
                    writer.write(line + System.lineSeparator());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isEligibleForReward() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate lastDate = LocalDate.parse(DDAY, formatter);

        return currentDate.isAfter(lastDate);
    }

    private void updateLastAttendanceDate() {
        DDAY = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        updateAttendanceDays();
    }

    private void updateAttendanceDays() {
        try {
            File file = new File("user_database.txt");
            ArrayList<String> lines = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts[0].equals(ID)) {
                        // 현재 사용자의 ID와 일치하는 라인을 찾아 출석일수를 오늘로 업데이트
                        parts[5] = DDAY;
                        parts[2] = String.valueOf(SCORE + 30);
                        line = String.join(",", parts);
                    }
                    lines.add(line);
                }
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for (String line : lines) {
                    writer.write(line + System.lineSeparator());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DailyRewardProgram().setVisible(true);
            }
        });
    }
}