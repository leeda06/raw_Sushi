package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class FireworkParticle {
    private int x;
    private int y;
    private int size;
    private Color color;
    private double xVelocity;
    private double yVelocity;
    private int lifespan; // 파티클 수명 (ms)
    private long creationTime; // 파티클 생성 시간

    public FireworkParticle(int x, int y, int size, Color color, double xVelocity, double yVelocity, int lifespan) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.lifespan = lifespan;
        this.creationTime = System.currentTimeMillis();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return System.currentTimeMillis() - creationTime < lifespan;
    }

    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {
        float alpha = 1.0f - (float) (System.currentTimeMillis() - creationTime) / lifespan;
        g.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), (int) (alpha * 255)));
        g.fillOval(x, y, size, size);
    }
}

class FireworkPanel extends JPanel {
    private List<FireworkParticle> particles;

    public FireworkPanel() {
        particles = new ArrayList<>();

        // 타이머를 이용하여 일정 간격으로 파티클을 움직이고 화면을 갱신
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                moveParticles();
                repaint();
            }
        }, 0, 20); // 20ms 간격으로 업데이트
    }

    public void createFirework(int x, int y) {
        // 파티클을 생성하여 리스트에 추가
        for (int i = 0; i < 50; i++) {
            double angle = Math.toRadians(Math.random() * 360);
            double speed = Math.random() * 5 + 1; // 속도는 1에서 6 사이의 랜덤 값
            double xVelocity = speed * Math.cos(angle);
            double yVelocity = speed * Math.sin(angle);

            Color color = new Color(
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256)
            );

            int lifespan = (int) (Math.random() * 500) + 10; // 수명은 1초에서 1.5초 사이의 랜덤 값

            FireworkParticle particle = new FireworkParticle(x, y, 5, color, xVelocity, yVelocity, lifespan);
            particles.add(particle);
        }
    }

    private void moveParticles() {
        // 파티클을 움직임
        Iterator<FireworkParticle> iterator = particles.iterator();
        while (iterator.hasNext()) {
            FireworkParticle particle = iterator.next();
            particle.move();

            // 파티클의 수명이 끝나면 리스트에서 제거
            if (!particle.isAlive()) {
                iterator.remove();
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 생성된 파티클을 그림
        for (FireworkParticle particle : particles) {
            particle.draw(g);
        }
    }
}

public class FireworkSimulator extends JFrame {
    public static final int WIDTH = 1080;
    public static final int HEIGHT = 720;
    public static final String LINK = "/static/db/img/";
    public static final String ID = "";
    public static String SCORE = "";
    Image screenImage;
    Graphics screenGraphics;
    JLabel background;
    public FireworkSimulator() {
        setSize(WIDTH, HEIGHT); // 창 크기 설정
        setTitle("원시초밥");
        setVisible(true);   // 창보이게
        background=null;//배경이미지
        setResizable(false);
        setLocationRelativeTo(null);

        FireworkPanel fireworkPanel = new FireworkPanel();
        add(fireworkPanel);

        // 마우스 클릭 시에 파티클 생성
        fireworkPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fireworkPanel.createFirework(evt.getX(), evt.getY());
            }
        });

        // 창 가운데에 위치하도록 설정
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FireworkSimulator().setVisible(true);
        });
    }

    public void paint(Graphics g) {//그리는 함수
        screenImage = createImage(Frame.WIDTH, Frame.HEIGHT);
        screenGraphics = screenImage.getGraphics();
        screenDraw(screenGraphics);
        g.drawImage(screenImage, 0, 0, null);//background를 그려줌
    }

    public void screenDraw(Graphics g) {
        paintComponents(g);
        this.repaint();
    }
}
