package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                new Item("기본테마", "기본테마.png", 50,1),
                new Item("기본테마", "기본테마.png", 30,2)
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
                new Main();
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
                        } else if (Frame.ITEM > item.getIndex()) {
                            JOptionPane.showMessageDialog(null, "이미 구매하신 아이템 입니다.");
                        } else {
                            JOptionPane.showMessageDialog(null, "먼저 이전 아이템을 구매하세요.");
                        }
                    } else if (items_turn == 1) {
                        if (Frame.ITEM != item.getIndex()) {
                            JOptionPane.showMessageDialog(null, "일회용입니다.\n구매 완료: " + item.getName());
                            Frame.ITEM = item.getIndex();
                        } else {
                            JOptionPane.showMessageDialog(null, "이미 구매하신 아이템 입니다.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "구매 완료: " + item.getName());
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "돈 부족!!\n현 잔액 : " + Frame.SCORE);
                }
            }
        });

        JLabel imageLabel = new JLabel(item.getImage());
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(buyButton, BorderLayout.NORTH);

        return panel;
    }

    public static void main(String[] args) {
        new Store();

    }
}
