package cn.scorpiodong;

import cn.scorpiodong.model.Command;
import cn.scorpiodong.model.Message;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * MyChatS - MainProject
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/8 1:39 下午
 */
public class MainProject {

    public static void main(String[] args) {
        try {
            ArrayList<Socket> allSockets = new ArrayList<>();
            ArrayList<String> allNames = new ArrayList<>();
            ServerSocket serverSocket = new ServerSocket(60000);
            ExecutorService readPool = Executors.newFixedThreadPool(50);
            ExecutorService writePool = Executors.newFixedThreadPool(5);
            while (true) {
                Socket socket = serverSocket.accept();
                readPool.submit(() -> {
                    try {
                        InputStream inputStream = socket.getInputStream();
                        OutputStream outputStream = socket.getOutputStream();
                        ObjectInput objectInput;
                        while (true) {
                            if (inputStream.available() > 0) {
                                objectInput = new ObjectInputStream(inputStream);
                                Command cmd = (Command) objectInput.readObject();
                                if (cmd != null) {
                                    if ("data".equals(cmd.getKey())) {
                                        Message msg = (Message) cmd.getValue();
                                        msg.setAddress(socket.getInetAddress().getHostAddress());
                                        publish(writePool, allSockets, new Command("data", msg));
                                    } else if ("ready".equals(cmd.getKey())) {
                                        allSockets.add(socket);
                                        publish(writePool, allSockets, new Command("addUser", cmd.getValue()));
                                        putMemberOnline(writePool,socket,allNames);
                                        allNames.add((String) cmd.getValue());
                                    } else if ("close".equals(cmd.getKey())) {
                                        objectInput.close();
                                        inputStream.close();
                                        outputStream.close();
                                        socket.close();
                                        allSockets.remove(socket);
                                        allNames.remove((String) cmd.getValue());
                                        publish(writePool, allSockets, new Command("delUser", cmd.getValue()));
                                        break;
                                    }
                                }
                            }
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向所有成员发布消息
     *
     * @param pool 输出线程池 ExecutorService
     * @param allSocket 所有成员 ArrayList
     * @param cmd 消息 Command
     */
    public static void publish(ExecutorService pool, ArrayList<Socket> allSocket, Command cmd) {
        System.out.println(cmd.getKey() + " : " + cmd.getValue());
        for (Socket socket : allSocket) {
            pool.submit(() -> {
                synchronized (socket) {
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
                        objectOutput.writeObject(cmd);
                        objectOutput.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /**
     * 向新加入的成员提供其他在线成员列表
     *
     * @param pool 输出线程池
     * @param socket 新加入成员
     */
    public static void putMemberOnline(ExecutorService pool, Socket socket, ArrayList<String> allNames) {
        for (String name : allNames) {
            pool.submit(() -> {
                synchronized (socket) {
                    try {
                        OutputStream outputStream = socket.getOutputStream();
                        ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
                        objectOutput.writeObject(new Command("addUser", name));
                        objectOutput.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
