package com.cherlshall.life.model;

import com.cherlshall.life.frame.MainFrame;
import com.cherlshall.life.util.ImageUtil;

import java.awt.*;

/**
 * @author hu.tengfei
 * @date 2019/9/9
 */
public class RoleFactory {

    private static Role lead;

    public static Role getLead() {
        if (lead == null) {
            Dimension size = MainFrame.getInstance().getContentPane().getSize();
            lead = new Role("Jack",
                    (int) size.getWidth() / 2 - 50,
                    (int) size.getHeight() - 100,
                    100, 100, ImageUtil.CXK_IMAGE_URL);
        }
        return lead;
    }
}
