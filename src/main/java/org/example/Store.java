package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Item {
    private String name;
    private ImageIcon image;
    private int price;

    public Item(String name, String imagePath, int price) {
        this.name = name;
        this.image = new ImageIcon(imagePath);
        this.price = price;
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
}

public class Store extends Frame {
    private JLabel background;
    private JPanel itemsPanel;
    private int currentPage;
    private int itemsPerPage = 3;

    public Store() {

        Item[] items = {
                new Item("물약", "potion.png", 10),
                new Item("갑옷", "armor.png", 50),
                new Item("검", "sword.png", 30),
                new Item("물약1", "potion.png", 12),
                new Item("갑옷1", "armor.png", 53),
                new Item("검1", "sword.png", 33),
                new Item("갑옷1", "armor.png", 53),
                new Item("검2", "sword.png", 33),
                new Item("갑옷2", "armor.png", 53),
                new Item("검2", "sword.png", 33),
                new Item("검2", "sword.png", 33),
                new Item("방패1", "shield.png", 55) // Fixed the image for the last item
                // Add more items
        };

        background = new JLabel(new ImageIcon(Main.class.getResource(Frame.LINK+"Store_/상점store.png")));
        background.setBounds(0, 0, WIDTH, HEIGHT);
        add(background);

        background.setLayout(new BorderLayout());

        // Left panel (size ratio 2)
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setPreferredSize(new Dimension(297, 300));
        JLabel leftLabel = new JLabel("왼쪽 라벨");
        leftLabel.setOpaque(true);
        leftLabel.setBackground(new Color(255, 0, 0, 20));
        leftPanel.add(leftLabel, BorderLayout.CENTER);
        background.add(leftPanel, BorderLayout.CENTER);

        // Right panel (size ratio 8)
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(255, 0, 0, 50));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(40, 0, 0, 0));

        // Right top label (green background)
        JPanel topRightLabel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, FlowLayout.TRAILING));
        topRightLabel.setOpaque(true);
        topRightLabel.setBackground(new Color(255, 0, 50, 50));
        rightPanel.add(topRightLabel, BorderLayout.NORTH);
        background.add(rightPanel, BorderLayout.EAST);

        currentPage = 0; // Initialize currentPage to 0

        itemsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        itemsPanel.setBackground(new Color(255, 0, 0, 0));

        for (int i = 0; i < itemsPerPage && i < items.length; i++) {
            itemsPanel.add(createItemPanel(items[i]));
        }

        JScrollPane scrollPane = new JScrollPane(itemsPanel);
        scrollPane.setBackground(new Color(255, 0, 0, 0));

        // Uncomment the nextButton-related code
        JButton nextButton = new JButton("다음 페이지");
        nextButton.setBounds(710, 210, 30, 30);  // Set the bounds with specific coordinates and size
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPage(items);
            }
        });

        JLabel Bottom = new JLabel(" ");
        rightPanel.add(nextButton, FlowLayout.LEFT);
        rightPanel.add(Bottom, FlowLayout.LEFT);
        topRightLabel.add(scrollPane, BorderLayout.CENTER);


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
        buyButton.setPreferredSize(new Dimension(783 / 4, 600 / 2));
        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "구매 완료: " + item.getName());
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
