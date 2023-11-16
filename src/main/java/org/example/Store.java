package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    int toPingpart = 0;
    int temaPart = -1;
    public Store() {

        Item[][] items1 = {{
                new Item("계란", "potion.png", 10,0),
                new Item("연어", "armor.png", 50,1),
                new Item("참치", "sword.png", 30,2),
                new Item("광어", "potion.png", 12,3),
                new Item("고등어", "armor.png", 53,4),
                new Item("마끼", "sword.png", 33,5)
                // Add more items
        },{
                new Item("코스튬1", "potion.png", 10,0),
                new Item("코스튬2", "armor.png", 50,1),
                new Item("코스튬3", "sword.png", 30,2),
                new Item("코스튬4", "potion.png", 12,3),
                new Item("코스튬5", "armor.png", 53,4),
                new Item("코스튬6", "sword.png", 33,5),
                new Item("코스튬7", "armor.png", 53,6),
                new Item("코스튬8", "sword.png", 33,7),
                new Item("코스튬9", "armor.png", 53,8),
                new Item("코스튬10", "sword.png", 33,9),
                new Item("코스튬11", "sword.png", 33,10),
                new Item("코스튬12", "shield.png", 55,11) // Fixed the image for the last item
                // Add more items
        }};

        background = new JLabel(new ImageIcon(Main.class.getResource(Frame.LINK+"Store_/상점store.png")));
        background.setBounds(0, 0, WIDTH, HEIGHT);
        add(background);

        background.setLayout(new BorderLayout());

        // Left panel (size ratio 2)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(297, 300));
        JLabel leftLabel = new JLabel("왼쪽 라벨");
        leftLabel.setOpaque(true);
        leftLabel.setBackground(new Color(0, 0, 0, 0));

        JButton items1Btn = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK + "Store_/토핑BTN.png")));
        items1Btn.setBounds(30,30,222, 90);
        items1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                items_turn = 0;
                currentPage = 0;
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
                nextPage(items1[items_turn]);
            }
        });

        leftPanel.add(leftLabel, BorderLayout.CENTER);
        leftLabel.add(items1Btn);
        leftLabel.add(items2Btn);
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

        for (int i = 0; i < itemsPerPage && i < items1.length; i++) {
            itemsPanel.add(createItemPanel(items1[items_turn][i]));
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setBackground(new Color(0, 0, 0, 0));

        // Uncomment the nextButton-related code
        JButton nextButton = new JButton("다음 페이지");
        nextButton.setBounds(700, 210, 30, 30);  // Set the bounds with specific coordinates and size
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    nextPage(items1[items_turn]);
            }
        });

        JLabel Bottom = new JLabel(" ");
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

        JLabel nameLabel = new JLabel("이름: " + item.getName());
        JLabel priceLabel = new JLabel("가격: " + item.getPrice());
        JButton buyButton = new JButton("구매하기");
        buyButton.setPreferredSize(new Dimension(195, 300));
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (items_turn == 0){
                    if(toPingpart == item.getIndex()){
                    JOptionPane.showMessageDialog(null, "구매 완료: " + item.getName());
                        toPingpart = toPingpart + 1;
                    } else if(toPingpart > item.getIndex()){
                        JOptionPane.showMessageDialog(null, "이미 구매하신 아이템 입니다.");
                    }else {
                        JOptionPane.showMessageDialog(null, "먼저 이전 아이템을 구매하세요.");
                    }
                } else if (items_turn == 1){
                    if(temaPart != item.getIndex()){
                        JOptionPane.showMessageDialog(null, "일회용입니다. 주의하세요.\n구매 완료: " + item.getName());
                        temaPart = item.getIndex();
                    } else {
                        JOptionPane.showMessageDialog(null, "이미 구매하신 아이템 입니다.");
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "구매 완료: " + item.getName());
                }
            }
        });

        JLabel imageLabel = new JLabel(item.getImage());
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(priceLabel, BorderLayout.SOUTH);
        panel.add(nameLabel);
        panel.add(buyButton, BorderLayout.NORTH);

        return panel;
    }

    public static void main(String[] args) {
        new Store();

    }
}
