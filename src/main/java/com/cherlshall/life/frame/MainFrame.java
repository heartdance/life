package com.cherlshall.life.frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author hu.tengfei
 * @date 2019/9/6
 */
public class MainFrame extends JFrame {

    private static MainFrame instance;

    private MainFrame() {
        setTitle("life");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                showCloseConfirm();
            }
        });
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
        }
        return instance;
    }

    public void showMenu() {
        MenuPanel menuPanel = new MenuPanel();
        add(menuPanel);
        setVisible(true);
    }

    public static void showCloseConfirm() {
        int closeCode = JOptionPane.showConfirmDialog(getInstance(), "Are you sure exit?", "Tips",
                JOptionPane.YES_NO_OPTION);
        if (closeCode == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void setPanel(JPanel panel) {
        Container c = getContentPane(); // 获取主容器对象
        if (panel instanceof  KeyListener) {
            panel.addKeyListener((KeyListener) panel);
        }
        c.removeAll(); // 删除容器中所有组件
        c.add(panel); // 容器添加面板
        c.validate(); // 容器重新验证所有组件
    }
}
