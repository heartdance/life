package com.cherlshall.life;

import com.cherlshall.life.frame.MainFrame;

/**
 * @author hu.tengfei
 * @date 2019/9/5
 */
public class Start {
    public static void main(String[] args) {
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.showMenu();
    }
}
