package cn.scorpiodong.mychatclient;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * MyChatClient - Index
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/4 7:27 下午
 */
public class Index {
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
