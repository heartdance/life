package com.cherlshall.life.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 菜单界面
 * @author hu.tengfei
 * @date 2019/9/6
 */
public class MenuPanel extends JPanel implements KeyListener {

    private int selectedLine = 0;

    public MenuPanel() {
        setBackground(Color.GREEN);
        MainFrame.getInstance().addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font font = new Font("黑体", Font.BOLD, 35);// 创建体字
        g.setFont(font);// 使用字体
        g.setColor(Color.BLACK);// 使用黑色
        g.drawString(selectedLine == 0 ? "- New Life" : "  New Life", 300, 300);
        g.drawString(selectedLine == 1 ? "- End Life" : "  End Life", 300, 360);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();// 获取按下的按键值
        switch (code) {// 判断按键值
            case KeyEvent.VK_UP:// 如果按下的是“↑”
                selectedLine -= 1;
                if (selectedLine < 0) {
                    selectedLine = 1;
                }
                repaint();
                break;
            case KeyEvent.VK_DOWN:
                selectedLine += 1;
                if (selectedLine > 1) {
                    selectedLine = 0;
                }
                repaint();
                break;
            case KeyEvent.VK_ENTER:
                if (selectedLine == 0) {
                    gotoNoviceVillage();
                } else if (selectedLine == 1) {
                    MainFrame.showCloseConfirm();
                }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void gotoNoviceVillage() {
        MainFrame.getInstance().removeKeyListener(this);
        InterludePanel.getInstance().gotoScene("Novice VillagePanel", new NoviceVillagePanel());
    }
}
