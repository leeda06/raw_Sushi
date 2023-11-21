package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class Item {
    private String name;
    private ImageIcon image;
    private int price;
    private int index;

    public Item(String name, String imagePath, int price, int index) {
        this.name = name;
        this.image = new ImageIcon(imagePath);
        this.price = price;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImage() {
        return image;
    }

    public int getPrice() {
        return price;
    }
    public int getIndex() {
        return index;
    }
}

public class Store extends Frame {
    private JLabel background;
    private JPanel itemsPanel;
    private int currentPage;
    private int itemsPerPage = 3;
    private int items_turn = 0;
    public Store() {
        if(Frame.GameDay > 3){
            Frame.GameDay = 0;
            new Main();
            setVisible(false);
        }else{
            Frame.GameDay ++;
        }
        Item[][] items1 = {{
                new Item("계란", "계란.png", 10,0),
                new Item("연어", "연어.png", 20,1),
                new Item("새우", "새우.png", 30,2),
                new Item("광어", "광어.png", 40,3),
                new Item("참치", "참치.png", 50,4),
                new Item("오징어", "오징어.png", 60,5)
                // Add more items
        },{
                new Item("기본테마", "기본테마.png", 0,0),
                new Item("기본테마", "기본테마.png", 0,1),
                new Item("기본테마", "기본테마.png", 0,2)
                // Add more items
        }};

        background = new JLabel(new ImageIcon(Main.class.getResource(Frame.LINK+"Store_/상점store.png")));
        background.setBounds(0, 0, WIDTH, HEIGHT);
        add(background);

        background.setLayout(new BorderLayout());

        // Uncomment the nextButton-related code
        JButton nextButton = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK + "Store_/nextBtn.png")));
        nextButton.setBounds(700, 210, 30, 30);  // Set the bounds with specific coordinates and size
        nextButton.setBackground(new Color(255,255,255, 0));
        nextButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage(items1[items_turn]);
            }
        });

        // Left panel (size ratio 2)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(297, 300));
        JLabel leftLabel = new JLabel(" ");
        leftLabel.setOpaque(true);
        leftLabel.setBackground(new Color(0, 0, 0, 0));

        JButton items1Btn = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK + "Store_/토핑BTN.png")));
        items1Btn.setBounds(30,30,222, 90);
        items1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                items_turn = 0;
                currentPage = 0;
                nextButton.setVisible(true);
                nextPage(items1[items_turn]);
            }
        });

        JButton items2Btn = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK + "Store_/테마BTN.png")));
        items2Btn.setBounds(30,140,222, 90);
        items2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                items_turn = 1;
                currentPage = 0;
                nextButton.setVisible(false);
                nextPage(items1[items_turn]);
            }
        });

        JButton frameBtn = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK + "Store_/돌아가기Btn.png")));
        frameBtn.setBounds(30,560,222, 90);
        frameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new gameTest();
                setVisible(false);
            }
        });

        leftPanel.add(leftLabel, BorderLayout.CENTER);
        leftLabel.add(items1Btn);
        leftLabel.add(items2Btn);
        leftLabel.add(frameBtn);
        background.add(leftPanel, BorderLayout.CENTER);

        // Right panel (size ratio 8)
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(0, 0, 0, 0));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        // Right top label (green background)
        JPanel topRightLabel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, FlowLayout.TRAILING));
        topRightLabel.setOpaque(true);
        topRightLabel.setBackground(new Color(0, 0, 0, 0));
        rightPanel.add(topRightLabel, BorderLayout.NORTH);
        background.add(rightPanel, BorderLayout.EAST);

        currentPage = 0; // Initialize currentPage to 0

        itemsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        itemsPanel.setBackground(new Color(0, 0, 0, 0));
        itemsPanel.setBorder(new EmptyBorder(0, 0, 0, 0));

        for (int i = 0; i < itemsPerPage && i < items1.length; i++) {
            itemsPanel.add(createItemPanel(items1[items_turn][i]));
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));



        JLabel Bottom = new JLabel("");
        rightPanel.add(nextButton, FlowLayout.LEFT);
        rightPanel.add(Bottom, FlowLayout.LEFT);
        topRightLabel.add(scrollPane, BorderLayout.CENTER);


        nextPage(items1[items_turn]);


    }

    private void nextPage(Item[] items) {
        int startIndex = currentPage * itemsPerPage;
        int endIndex = startIndex + itemsPerPage;

        if (startIndex < items.length) {
            itemsPanel.removeAll();

            for (int i = startIndex; i < endIndex && i < items.length; i++) {
                itemsPanel.add(createItemPanel(items[i]));
            }

            currentPage++;

            if (endIndex >= items.length) {
                currentPage = 0;
            }

            System.out.println(currentPage);
            revalidate();
            repaint();
        }
    }

    private JPanel createItemPanel(Item item) {
        JPanel panel = new JPanel(new BorderLayout());

        JButton buyButton = new JButton( new ImageIcon(Main.class.getResource(Frame.LINK+"Store_/ingredient/img"+item.getImage())));
        buyButton.setPreferredSize(new Dimension(195, 320));

        buyButton.setBorder(new EmptyBorder(0, 0, 0, 0));
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Frame.SCORE >= item.getPrice()) {
                    if (items_turn == 0) {
                        if (Frame.ITEM == item.getIndex()) {
                            JOptionPane.showMessageDialog(null, "구매 완료: " + item.getName());
                            Frame.ITEM = Frame.ITEM + 1;
                            Frame.SCORE -= item.getPrice();
                        } else if (Frame.ITEM > item.getIndex()) {
                            JOptionPane.showMessageDialog(null, "이미 구매하신 아이템 입니다.");
                        } else {
                            JOptionPane.showMessageDialog(null, "먼저 이전 아이템을 구매하세요.");
                        }
                    } else if (items_turn == 1) {
                        if (Frame.TEMA != item.getIndex()) {
                            JOptionPane.showMessageDialog(null, "일회용입니다.\n구매 완료: " + item.getName());
                            Frame.TEMA = item.getIndex();
                            Frame.SCORE -= item.getPrice();
                        } else {
                            JOptionPane.showMessageDialog(null, "이미 구매하신 아이템 입니다.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "구매 완료: " + item.getName());

                        Frame.SCORE -= item.getPrice();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "돈 부족!!\n현 잔액 : " + Frame.SCORE);
                }

                try {
                    updateScoreById("user_database.txt");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        JLabel imageLabel = new JLabel(item.getImage());
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(buyButton, BorderLayout.NORTH);

        return panel;
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
                columns[3] = String.valueOf(Frame.ITEM);
                columns[4] = String.valueOf(Frame.TEMA);
                columns[7] = String.valueOf(Frame.GameDay);
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

    private void modifyScoreInFile(String filePath, String targetId, int newScore) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter("임시파일.txt"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // 각 라인을 아이디와 점수로 분리
                String[] parts = line.split(",");
                    String id = parts[0].trim();
                    int score = Integer.parseInt(parts[2].trim());

                    // 특정 아이디를 찾아 점수 변경
                    if (id.equals(targetId)) {
                        score = newScore;
                    }

                    // 변경된 내용을 쓰기
                    writer.write(id + ", " + score);
                    writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 원본 파일 삭제 및 임시 파일을 원본 파일로 변경
        File originalFile = new File(filePath);
        File tempFile = new File("임시파일.txt");

        if (tempFile.renameTo(originalFile)) {
            System.out.println("점수 수정 완료.");
        } else {
            System.out.println("점수 수정 실패.");
        }
    }

    private void modifyScoreById(String targetId, int newScore) {
        // 사용할 파일 경로를 설정
        String filePath = "user_database.txt"; // 실제 파일 경로로 변경

        // 파일에서 특정 아이디의 점수를 변경
        modifyScoreInFile(filePath, targetId, newScore);
    }

    public static void main(String[] args) {

    }
}
