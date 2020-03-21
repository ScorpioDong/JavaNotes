package cn.scorpiodong.controller;

import cn.scorpiodong.MainProject;
import cn.scorpiodong.model.Message;
import cn.scorpiodong.util.LogUtils;
import cn.scorpiodong.util.NetConfig;
import cn.scorpiodong.util.NetUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.HashMap;
import java.util.Iterator;

/**
 * StudentManage - Server
 * 服务端网络功能
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 7:53 PM
 */
@NetConfig()
public class Server implements Runnable {
    /**
     * 客户端Channel集合
     */
    private HashMap<Integer, SocketChannel> allUser;
    /**
     * 客户端计数器
     */
    private int count = 0;

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;

    /**
     * 构造方法， 初始化ServerSocketChannel和Selector
     */
    public Server() {
        allUser = new HashMap<>();
        int port = Server.class.getAnnotation(NetConfig.class).port();
        try {
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(port));
            serverSocketChannel.configureBlocking(false);
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将消息发送给指定id的Socket
     * @param id int 需要发送的Socket的ID
     * @param msg 需要发送的消息
     * @throws ClosedChannelException SocketChannel关闭异常
     */
    public void sendMessage(int id, String msg) throws ClosedChannelException {
        byte[] msgBytes = msg.getBytes();
        ByteBuffer buf = ByteBuffer.allocate(msgBytes.length);
        buf.put(msgBytes).flip();
        SocketChannel channel = allUser.get(id);
        channel.register(selector, SelectionKey.OP_WRITE, buf);
    }

    /**
     * Selector消息处理
     */
    @Override
    public void run() {
        while (true) {
            try {
                if (selector.select() > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isAcceptable()) {
                            try {
                                SocketChannel socket = serverSocketChannel.accept();
                                LogUtils.logDebug("用户接入：" + socket.getRemoteAddress());
                                socket.configureBlocking(false);
                                // 连接后发送用户ID到客户端
                                NetUtils.send(socket, new Message("user_id", count).toJsonString());
                                socket.register(selector, SelectionKey.OP_READ);
                                allUser.put(count++, socket);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else if (key.isReadable()) {
                            // TODO 读事件

                        } else if (key.isWritable() && key.isValid()) {
                            // TODO 写事件
                            SocketChannel channel = (SocketChannel) key.channel();
                            channel.write((ByteBuffer) key.attachment());
                            // 发送之后要取消写事件，不然会重复触发
                            key.interestOps(key.interestOps() & ~SelectionKey.OP_WRITE);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
