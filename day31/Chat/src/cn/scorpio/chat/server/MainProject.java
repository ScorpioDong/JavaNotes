package cn.scorpio.chat.server;

import java.io.IOException;

/**
 * Chat - MainProject
 * Server主程序
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/16 9:04 下午
 */
public class MainProject {
    public static void main(String[] args) throws IOException {
        new Thread(new ChatServer()).start();
    }
}
