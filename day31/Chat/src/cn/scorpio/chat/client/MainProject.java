package cn.scorpio.chat.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * Chat - MainProject
 * Client主程序
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/16 9:05 下午
 */
public class MainProject {
    public static void main(String[] args) throws IOException, InterruptedException {
        ChatClient client = new ChatClient();
        new Thread(client).start();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            client.sendMsg(str);
        }
    }
}
