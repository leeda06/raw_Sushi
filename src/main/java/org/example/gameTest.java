package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.Timer;
import java.util.TimerTask;

public class gameTest extends Frame{
    int expectedIndex = 1;
    //boolean
    boolean on1 = false;
    boolean on2 = false;

    static int count = 1;
    gameTest(){
        setLayout(null);

//
//        Timer m_timer = new Timer();
//        TimerTask m_task = new TimerTask() {
//            @Override
//            public void run() {
//                if(count <= 3){
//                    count++;
//                } else {
//                    m_timer.cancel();
//                }
//            }
//        };
//        m_timer.schedule(m_task, 1000, 1000);

        JButton button1 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image1.jpg")));
        button1.setBounds(220, 370, 100, 50);
        add(button1);
        JButton button2 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image2.jpg")));
        button2.setBounds(340, 370, 100, 50);
        add(button2);
        JButton button3 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image3.jpg")));
        button3.setBounds(460, 370, 100, 50);
        add(button3);
        JButton button4 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image4.jpg")));
        button4.setBounds(580, 370, 100, 50);
        add(button4);
        JButton button5 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/image5.jpg")));
        button5.setBounds(700, 370, 100, 50); // Set the button's position and size
        add(button5);
        JButton wasabi = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/wasabitong.jpg")));
        wasabi.setBounds(670, 430, 60, 60); // Set the button's position and size
        add(wasabi);
        JButton rice = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/ricetong.jpg")));
        rice.setBounds(740, 450, 180, 129); // Set the button's position and size
        add(rice);

        // 이미지 아이콘
        ImageIcon icon1 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image1.jpg"));
        ImageIcon icon2 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image2.jpg"));
        ImageIcon icon3 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image3.jpg"));
        ImageIcon icon4 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image4.jpg"));
        ImageIcon icon5 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image5.jpg"));
        ImageIcon iconWasabi = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/wasabi.png"));
        ImageIcon iconRice = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/rice.png"));
        ImageIcon iconDoma = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/doma.jpg"));
        ImageIcon iconWood1 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/wood1.png"));
        ImageIcon iconWood2 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/wood2.png"));
        //이미지 삽입
        JLabel label1 = new JLabel(icon1);
        JLabel label2 = new JLabel(icon2);
        JLabel label3 = new JLabel(icon3);
        JLabel label4 = new JLabel(icon4);
        JLabel label5 = new JLabel(icon5);
        JLabel labelWasabi = new JLabel(iconWasabi);
        JLabel labelRice = new JLabel(iconRice);
        JLabel labelDoma = new JLabel(iconDoma);
        JLabel labelWood1 = new JLabel(iconWood1);
        JLabel labelWood2 = new JLabel(iconWood2);

        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        labelWasabi.setVisible(false);
        labelRice.setVisible(false);
        labelDoma.setVisible(true);
        labelWood1.setVisible(true);
        labelWood2.setVisible(true);
        // 위치
        label1.setBounds(400, 420, 200, 200);
        label2.setBounds(400, 420, 200, 200);
        label3.setBounds(400, 420, 200, 200);
        label4.setBounds(400, 420, 200, 200);
        label5.setBounds(400, 420, 200, 200);
        labelWasabi.setBounds(470, 520, 60, 60);
        labelRice.setBounds(425, 550, 150, 50);
        labelDoma.setBounds(400, 470, 200, 200);
        labelWood1.setBounds(0, 340, 1080, 700);
        labelWood2.setBounds(0, 270, 1080, 70);
        //추가
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(labelWasabi);
        add(labelRice);
        add(labelDoma);
        add(labelWood1);
        add(labelWood2);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 2) {
                    on1 = !on1; // 현재 값을 반대로 변경 ex) true -> false
                    label1.setVisible(on1); // 시각적 표현 변경
                    expectedIndex++;
                } else {
                    on2 = !on2;
                    label1.setVisible(on2);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 2) {
                    on1 = !on1;
                    expectedIndex++;
                } else {
                    on2 = !on2;
                    label2.setVisible(on2);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 2) {
                    on1 = !on1;
                    label3.setVisible(on1);
                    expectedIndex++;
                } else {
                    on2 = !on2;
                    label3.setVisible(on2);
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 2) {
                    on1 = !on1;
                    label4.setVisible(on1);
                    expectedIndex++;
                } else {
                    on2 = !on2;
                    label4.setVisible(on2);
//                    handleFailure1(label4);
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 3) {
                    on1 = !on1;
                    label5.setVisible(on1);
                    expectedIndex++;
                } else {
                    on2 = !on2;
                    label5.setVisible(on2);
//                    handleFailure1(label5);
                }
            }
        });
        wasabi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 2) {
                    on1 = !on1;
                    labelWasabi.setVisible(on1);
                    expectedIndex++;
                } else {
                    on2 = !on2;
                    labelWasabi.setVisible(on2);
                    handleFailure2(labelWasabi);
                }
            }
        });
        rice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(expectedIndex == 1){
                    on1 = !on1;
                    labelRice.setVisible(on1);
                    expectedIndex++;
                } else {
                    on2 = !on2;
                    labelRice.setVisible(on2);
                    handleFailure2(labelWasabi);
                }
            }
        });
    }
//    private void handleFailure1(JLabel label4, JLabel label5) {
//        // 실패하면 안보이게 하기
//        label4.setVisible(false);
//        label5.setVisible(false);
//
//
//    }
    private void handleFailure2(JLabel labelWasabi){
        labelWasabi.setVisible(false);
    }
    public static void main(String[] args) {
        new gameTest();
    }

}