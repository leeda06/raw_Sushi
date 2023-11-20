package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;

public class gameTest extends Frame{
    int expectedIndex = 1;
    //boolean
    boolean on1 = false;
    boolean on1_2 = false;
    boolean on2 = false;
    boolean on2_2 = false;
    boolean on3 = false;
    boolean on3_2 = false;
    boolean on4 = false;
    boolean on4_2 = false;
    boolean on5 = false;
    boolean on5_2 = false;
    boolean on6 = false;
    boolean on6_2 = false;
    boolean on7 = false;
    boolean on7_2 = true;
    boolean on8 = false;
    boolean on8_2 = true;


    private ImageIcon icon1 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/ingredients1.png"));
    private ImageIcon icon2 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/ingredients2.png"));
    private ImageIcon icon3 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/ingredients3.png"));
    private ImageIcon icon4 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/ingredients4.png"));
    private ImageIcon icon5 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/ingredients5.png"));
    private ImageIcon icon6 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/ingredients6.png"));
    private ImageIcon sushi1 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image1.jpg"));
    private ImageIcon sushi2 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image2.jpg"));
    private ImageIcon sushi3 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image3.jpg"));
    private ImageIcon sushi4 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image4.jpg"));
    private ImageIcon sushi5 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image5.jpg"));
    private ImageIcon sushi6 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/image6.jpg"));
    private ImageIcon iconWasabi = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/wasabi.png"));
    private ImageIcon iconRice = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/rice.png"));
    private ImageIcon iconDoma = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/doma.jpg"));
    private ImageIcon iconDish1 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/dish1.jpg"));
    private ImageIcon iconDish2 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/dish2.jpg"));
    private ImageIcon iconWood1 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/wood1.png"));
    private ImageIcon iconWood2 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/wood2.png"));
    private ImageIcon iconCustomer1 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/customer1.jpg"));
    private ImageIcon iconCustomer2 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/customer2.jpg"));
    private ImageIcon iconCustomer3 = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/customer3.jpg"));
    private ImageIcon iconOrder1 = new ImageIcon((Main.class.getResource(LINK+"/GameStart_/order1.png")));
    private ImageIcon iconThankyou = new ImageIcon((Main.class.getResource(LINK+"/GameStart_/thankyou.png")));
    private ImageIcon iconSky = new ImageIcon(Main.class.getResource(LINK+"/GameStart_/sky.png"));
    //이미지 삽입
    private JLabel label1 = new JLabel(icon1);
    private JLabel label2 = new JLabel(icon2);
    private JLabel label3 = new JLabel(icon3);
    private JLabel label4 = new JLabel(icon4);
    private JLabel label5 = new JLabel(icon5);
    private JLabel label6 = new JLabel(icon6);
    private JLabel labelSushi1 = new JLabel(sushi1);
    private JLabel labelSushi2 = new JLabel(sushi2);
    private JLabel labelSushi3 = new JLabel(sushi3);
    private JLabel labelSushi4 = new JLabel(sushi4);
    private JLabel labelSushi5 = new JLabel(sushi5);
    private JLabel labelSushi6 = new JLabel(sushi6);
    private JLabel labelWasabi = new JLabel(iconWasabi);
    private JLabel labelRice = new JLabel(iconRice);
    private JLabel labelDoma = new JLabel(iconDoma);
    private JLabel labelDish1 = new JLabel(iconDish1);
    private JLabel labelDish2 = new JLabel(iconDish2);
    private JLabel labelWood1 = new JLabel(iconWood1);
    private JLabel labelWood2 = new JLabel(iconWood2);
    private JLabel labelCustomer1 = new JLabel(iconCustomer1);
    private JLabel labelCustomer2 = new JLabel(iconCustomer2);
    private JLabel labelCustomer3 = new JLabel(iconCustomer3);
    private JLabel labelOrder1 = new JLabel(iconOrder1);
    private JLabel labelThankyou = new JLabel(iconThankyou);
    private JLabel labelSky = new JLabel(iconSky);
    gameTest(){
        setLayout(null);

//        int delay = 40000;
//        Timer m_timer = new Timer();
//        TimerTask m_task = new TimerTask(delay, new ActionListener() {
//            @Override
//            public void run() {
//
//            }
//        }) {
//
//        };
//    m_timer.schedule(m_task, 1000, 1000);

        JButton button1 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/sushiTong1.jpg")));
        button1.setBounds(180, 350, 120, 120);
        add(button1);
        JButton button2 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/sushiTong2.jpg")));
        button2.setBounds(300, 350, 120, 120);
        add(button2);
        JButton button3 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/sushiTong3.jpg")));
        button3.setBounds(420, 350, 120, 120);
        add(button3);
        JButton button4 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/sushiTong4.jpg")));
        button4.setBounds(540, 350, 120, 120);
        add(button4);
        JButton button5 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/sushiTong5.jpg")));
        button5.setBounds(660, 350, 120, 120); // Set the button's position and size
        add(button5);
        JButton button6 = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/sushiTong6.jpg")));
        button6.setBounds(780, 350, 120, 120); // Set the button's position and size
        add(button6);
        JButton wasabi = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/wasabitong.jpg")));
        wasabi.setBounds(670, 480, 60, 60); // Set the button's position and size
        add(wasabi);
        JButton rice = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/ricetong.jpg")));
        rice.setBounds(760, 480, 180, 129); // Set the button's position and size
        add(rice);
        JButton clear = new JButton(new ImageIcon(Main.class.getResource(Frame.LINK+"GameStart_/clear.png")));
        clear.setBounds(640, 560, 100, 50);
        add(clear);

        // 이미지 아이콘


        label1.setVisible(false);
        label2.setVisible(false);
        label3.setVisible(false);
        label4.setVisible(false);
        label5.setVisible(false);
        label6.setVisible(false);
        labelSushi1.setVisible(false);
        labelSushi2.setVisible(false);
        labelSushi3.setVisible(false);
        labelSushi4.setVisible(false);
        labelSushi5.setVisible(false);
        labelSushi6.setVisible(false);
        labelWasabi.setVisible(false);
        labelRice.setVisible(false);
        labelDoma.setVisible(true);
        labelDish1.setVisible(true);
        labelDish2.setVisible(true);
        labelWood1.setVisible(true);
        labelWood2.setVisible(true);
        labelCustomer1.setVisible(false);
        labelCustomer2.setVisible(true);
        labelCustomer3.setVisible(false);
        labelOrder1.setVisible(true);
        labelThankyou.setVisible(false);
        labelSky.setVisible(true);

        // 위치
        label1.setBounds(400, 450, 200, 200);
        label2.setBounds(400, 450, 200, 200);
        label3.setBounds(400, 450, 200, 200);
        label4.setBounds(400, 450, 200, 200);
        label5.setBounds(400, 450, 200, 200);
        label6.setBounds(400, 450, 200, 200);
        labelWasabi.setBounds(470, 550, 60, 60);
        labelRice.setBounds(400, 480, 200, 150);
        labelDoma.setBounds(400, 470, 200, 200);
        labelDish1.setBounds(200, 270,200,70);
        labelDish2.setBounds(450, 270,200,70);
        labelWood1.setBounds(0, 340, 1080, 700);
        labelWood2.setBounds(0, 270, 1080, 70);
        labelCustomer1.setBounds(150, 70, 180, 200);
        labelCustomer2.setBounds(165, 70, 150, 200);
        labelOrder1.setBounds(400,100,200,111);
        labelThankyou.setBounds(400,100,200,114);
        labelSky.setBounds(0,0,1080,500);

        //추가
        add(label1);
        add(label2);
        add(label3);
        add(label4);
        add(label5);
        add(label6);
        add(labelSushi1);
        add(labelSushi2);
        add(labelSushi3);
        add(labelSushi4);
        add(labelSushi5);
        add(labelSushi6);
        add(labelWasabi);
        add(labelRice);
        add(labelDoma);
        add(labelDish1);
        add(labelDish2);
        add(labelWood1);
        add(labelWood2);
        add(labelCustomer1);
        add(labelCustomer2);
        add(labelCustomer3);
        add(labelOrder1);
        add(labelThankyou);
        add(labelSky);

        labelOrder1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                labelSushi6.setVisible(false);
                labelOrder1.setVisible(false);
                labelThankyou.setVisible(true);
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(on1 == true && on7 == true && on8 == true) {
                    label1.setVisible(false);
                    labelWasabi.setVisible(false);
                    labelRice.setVisible(false);
                    labelSushi1.setVisible(true);
                    labelSushi1.setBounds(200, 200, 200,150);
                    expectedIndex = 1;
                    on1 = !on1;
                    on7 = !on7;
                    on8 = !on8;
                } else if(on2 == true && on7 == true && on8 == true) {
                    label2.setVisible(false);
                    labelWasabi.setVisible(false);
                    labelRice.setVisible(false);
                    labelSushi2.setVisible(true);
                    labelSushi2.setBounds(200, 190,200,200);
                    expectedIndex = 1;
                    on2 = !on2;
                    on7 = !on7;
                    on8 = !on8;
                } else if(on3 == true && on7 == true && on8 == true) {
                    label3.setVisible(false);
                    labelWasabi.setVisible(false);
                    labelRice.setVisible(false);
                    labelSushi3.setVisible(true);
                    labelSushi3.setBounds(200, 190,200,200);
                    expectedIndex = 1;
                    on3 = !on3;
                    on7 = !on7;
                    on8 = !on8;
                } else if(on4 == true && on7 == true && on8 == true) {
                    on6 = !on6;
                    on7 = !on7;
                    label4.setVisible(false);
                    labelWasabi.setVisible(false);
                    labelRice.setVisible(false);
                    labelSushi4.setVisible(true);
                    labelSushi4.setBounds(200, 190,200,200);
                    expectedIndex = 1;
                    on4 = !on4;
                    on7 = !on7;
                    on8 = !on8;
                } else if(on5 == true && on7 == true && on8 == true) {
                    on6 = !on6;
                    on7 = !on7;
                    label5.setVisible(false);
                    labelWasabi.setVisible(false);
                    labelRice.setVisible(false);
                    labelSushi5.setVisible(true);
                    labelSushi5.setBounds(200, 190,200,200);
                    expectedIndex = 1;
                    on5 = !on5;
                    on7 = !on7;
                    on8 = !on8;
                } else if(on6 == true && on7 == true && on8 == true) {
                    on6 = !on6;
                    on7 = !on7;
                    label6.setVisible(false);
                    labelWasabi.setVisible(false);
                    labelRice.setVisible(false);
                    labelSushi6.setVisible(true);
                    labelSushi6.setBounds(200, 190,200,200);
                    expectedIndex = 1;
                    on6 = !on6;
                    on7 = !on7;
                    on8 = !on8;
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 3) {
                    imgVisible(1);
                } else {
                    label1.setVisible(on1_2);

                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 3) {
                    imgVisible(2);
                } else {
                    label2.setVisible(on2_2);
                }
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 3) {
                    imgVisible(3);
                } else {
                    label3.setVisible(on3_2);
                }
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 3) {
                    imgVisible(4);
                } else {
                    label4.setVisible(on4_2);
                }
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 3) {
                    imgVisible(5);
                } else {
                    label5.setVisible(on5_2);
                }
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 3) {
                    imgVisible(6);
                } else {
                    label6.setVisible(on6_2);
                }
            }
        });

        wasabi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (expectedIndex == 2) {
                    imgVisible(7);
                    expectedIndex++;
                } else {
                    labelWasabi.setVisible(on7_2);
                }
            }
        });
        rice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(expectedIndex == 1){
                    imgVisible(8);
                    expectedIndex++;
                } else {
                    labelRice.setVisible(on8_2);
                }
            }
        });


    }

    private void imgVisible(int number){
        boolean imgNumber[] = {false,false,false,false,false,false,false,false};
        for (int i = 0; i < imgNumber.length;i++){
            if(i == number - 1 || (i == 6 && on7 == true) || (i == 7 && on8 == true)){
                imgNumber[i] = true;
            }
        }
        on1 = imgNumber[0];
        on2 = imgNumber[1];
        on3 = imgNumber[2];
        on4 = imgNumber[3];
        on5 = imgNumber[4];
        on6 = imgNumber[5];
        on7 = imgNumber[6];
        on8 = imgNumber[7];

        label1.setVisible(on1);
        label2.setVisible(on2);
        label3.setVisible(on3);
        label4.setVisible(on4);
        label5.setVisible(on5);
        label6.setVisible(on6);
        labelWasabi.setVisible(on7);
        labelRice.setVisible(on8);
    }
    public static void main(String[] args) {
        new gameTest();
    }

}