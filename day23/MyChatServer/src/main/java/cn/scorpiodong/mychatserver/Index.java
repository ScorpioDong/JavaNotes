package cn.scorpiodong.mychatserver;

import com.alibaba.fastjson.JSON;

import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MyChatServer - Index 主程序
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/4 7:07 下午
 */
public class Index {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(Config.PORT);
        ExecutorService pool = Executors.newFixedThreadPool(5);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.submit(() -> {
                try {
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    while (true) {
                        byte[] buf = new byte[1024];
                        int length = inputStream.read(buf);
                        if (length > 0) {
                            String data = new String(buf,0,length);
                            System.out.println(data);
                            User user = JSON.parseObject(data, User.class);
                            user.setIp(socket.getLocalAddress().getHostAddress());
                            outputStream.write(JSON.toJSONBytes(user));
                            if ("close".equals(user.getCmd())) {
                                break;
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        }
    }
}
