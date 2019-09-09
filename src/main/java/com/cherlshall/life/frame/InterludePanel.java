package com.cherlshall.life.frame;

import javax.swing.*;
import java.awt.*;

/**
 * @author hu.tengfei
 * @date 2019/9/9
 */
public class InterludePanel extends JPanel {

    private static InterludePanel instance = new InterludePanel();
    private String sceneName;

    private InterludePanel() {
        setBackground(Color.BLACK);
    }

    public static InterludePanel getInstance() {
        return instance;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font font = new Font("楷体", Font.BOLD, 50);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics(font);
        int textWidth = fm.stringWidth(this.sceneName);
        g.setColor(Color.RED);
        int width = MainFrame.getInstance().getWidth();
        int x = (width - textWidth) / 2;
        g.drawString(this.sceneName, x, 300);
    }

    public void gotoScene(String sceneName, JPanel scene) {
        this.sceneName = sceneName;
        new Thread(() -> {
            MainFrame.getInstance().setPanel(this);
            repaint();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MainFrame.getInstance().setPanel(scene);
        }).start();
    }

}
