package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DailyRewardApp extends JFrame {

    private int dailyRewardCount = 0;
    private JLabel rewardLabel;
    private JLabel titleLabel;

    public DailyRewardApp() {
        setTitle("일일 보상 프로그램");
        setSize(300, 200);

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

        // 레이블 초기화
        rewardLabel = new JLabel(formattedDate);
        rewardLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel = new JLabel("오늘 날짜");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        // 버튼 초기화
        JButton rewardButton = new JButton("보상 받기");
        rewardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate DDate = LocalDate.parse(Frame.DDAY, formatter);
                String dateString = currentDate.format(formatter);
                if(currentDate.isAfter(DDate)){
                    JOptionPane.showMessageDialog(null, "보상을 받았습니다!");
                    Frame.DDAY = dateString;
                    Frame.COUNT ++;
                    try {
                        updateScoreById("user_database.txt");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "오늘 이미 보상을 받았습니다!");
                }
            }
        });

        // 프레임에 컴포넌트 추가
        setLayout(new BorderLayout());
        add(titleLabel, BorderLayout.NORTH);
        add(rewardLabel, BorderLayout.CENTER);
        add(rewardButton, BorderLayout.SOUTH);

        // 화면 가운데 정렬
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DailyRewardApp().setVisible(true);
            }
        });
    }

    private static void updateScoreById(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] columns = line.split(",");

            // 가정: 각 열의 순서가 아이디, 비밀번호, 점수, 토핑 단계, 테마 번호, 날짜, 목숨 순서라고 가정
            String id = columns[0].trim(); // 아이디 추출

            if (id.equals(Frame.ID)) {
                // 아이디가 일치하는 경우 점수 열을 변경
                columns[2] = String.valueOf(Frame.SCORE);
                columns[5] = String.valueOf(Frame.DDAY);
                columns[6] = String.valueOf(Frame.COUNT);
                // 변경된 열을 다시 문자열로 조합
                String updatedLine = String.join(",", columns);
                // 리스트에서 해당 라인을 업데이트
                lines.set(i, updatedLine);
                break; // 이미 찾았으므로 루프 종료
            }
        }

        // 변경된 내용을 파일에 쓰기
        Files.write(path, lines, StandardCharsets.UTF_8);
    }
}
