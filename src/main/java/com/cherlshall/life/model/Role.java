package com.cherlshall.life.model;

import com.cherlshall.life.frame.MainFrame;

import java.awt.*;

/**
 * @author hu.tengfei
 * @date 2019/9/6
 */
public class Role extends DisplayableImage {
    private String name;
    private int speed;

    public Role(String name, int x, int y, int width, int height, String url) {
        super(x, y, width, height, url);
        this.name = name;
        this.speed = 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void left() {
        Insets insets = MainFrame.getInstance().getInsets();
        int x = this.getX() - speed;
        int minX = insets.left;
        this.setX(x < minX ? minX : x);
    }

    public void right() {
        Insets insets = MainFrame.getInstance().getInsets();
        int width = MainFrame.getInstance().getWidth();
        int maxX = width - insets.left;
        int x = this.getX() + speed;
        this.setX(x > maxX ? maxX : x);
    }

    public void up() {
        Insets insets = MainFrame.getInstance().getInsets();
        int minY = insets.top;
        int y = this.getY() - speed;
        this.setY(y < minY ? minY : y);
    }

    public void down() {
        Insets insets = MainFrame.getInstance().getInsets();
        int height = MainFrame.getInstance().getHeight();
        int maxY = height - insets.bottom;
        int y = this.getY() + speed;
        this.setY(y > maxY ? maxY : y);
    }
}
