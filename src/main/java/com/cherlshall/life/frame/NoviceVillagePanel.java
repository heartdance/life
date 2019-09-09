package com.cherlshall.life.frame;

import com.cherlshall.life.model.Role;
import com.cherlshall.life.model.RoleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author hu.tengfei
 * @date 2019/9/6
 */
public class NoviceVillagePanel extends JPanel implements KeyListener {

    private static final int FRESH_TIME = 10;

    public NoviceVillagePanel() {
        ScheduledExecutorService freshThread = Executors.newScheduledThreadPool(1);
        MainFrame.getInstance().addKeyListener(this);
        freshThread.scheduleWithFixedDelay(() -> {
            repaint();
            System.gc();
        }, FRESH_TIME, FRESH_TIME, TimeUnit.MILLISECONDS);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);// 使用黑色
        g.fillRect(0, 0, getWidth(), getHeight()); // 填充一个覆盖整个面板的黑色矩形
        g.setFont(new Font("微软雅黑", Font.BOLD, 20));
        g.setColor(Color.CYAN);// 使用cyan色
        g.drawString("Novice Village", 10, 30);
        g.setColor(Color.RED);// 使用红色
        Role lead = RoleFactory.getLead();
        g.drawImage(lead.getImage(), lead.getX(), lead.getY(), lead.getWidth(), lead.getHeight(), this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                RoleFactory.getLead().up();
                break;
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                RoleFactory.getLead().left();
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                RoleFactory.getLead().down();
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                RoleFactory.getLead().right();
                break;
            case KeyEvent.VK_ESCAPE:
                gotoMenu();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void gotoMenu() {
        MainFrame.getInstance().removeKeyListener(this);
        InterludePanel.getInstance().gotoScene("Menu", new MenuPanel());
    }
}
