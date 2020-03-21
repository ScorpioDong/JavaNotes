package cn.scorpio.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Chat - ChatServer
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/16 9:28 下午
 */
public class ChatServer implements Runnable {

    private static final int PORT = 20531;

    private ServerSocketChannel serverSocket;
    private Selector selector;

    public ChatServer() throws IOException {
        serverSocket = ServerSocketChannel.open();
        selector = Selector.open();
        serverSocket.configureBlocking(false);
        serverSocket.bind(new InetSocketAddress(PORT));
        serverSocket.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void sendMsg(SocketChannel socket, String msg) throws ClosedChannelException {
        ByteBuffer buf = ByteBuffer.wrap(msg.getBytes());
        socket.register(selector, SelectionKey.OP_WRITE, buf);
        selector.wakeup();
    }

    public void receiveMsg(SelectionKey key) throws IOException {
        SocketChannel socket = (SocketChannel) key.channel();
        ByteBuffer buf = ByteBuffer.allocate(1024 * 4);
        int length = socket.read(buf);
        if (-1 == length) {
            closeChannel(key, socket);
        }else if (0 != length) {
            String msg = new String(buf.array(), 0, length);
            processMsg(key, msg);
        }
    }

    public void processMsg(SelectionKey key, String msg) throws IOException {
        SocketChannel socket = (SocketChannel) key.channel();
        if (msg.startsWith("@")) {
            // TODO 私聊
        } else if (msg.startsWith("/close")) {
            closeChannel(key, socket);
        } else {
            msg = socket.getRemoteAddress().toString().substring(1) + " : " + msg;
            broadcast(socket, msg);
        }
    }

    private void closeChannel(SelectionKey key, SocketChannel socket) throws IOException {
        broadcast(socket, socket.getRemoteAddress().toString().substring(1) + " 已下线");
        socket.close();
        key.cancel();
    }

    public void broadcast(SocketChannel self, String msg) throws ClosedChannelException {
        for (SelectionKey key : selector.keys()) {
            SelectableChannel channel = key.channel();
            if (channel instanceof SocketChannel) {
            //if (channel instanceof SocketChannel && channel.equals(self)) {
                SocketChannel socket = (SocketChannel) key.channel();
                sendMsg(socket, msg);
                System.out.println(msg);
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (0 == selector.select(2000)) {
                    continue;
                }

                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    if (key.isAcceptable()) {
                        SocketChannel socket = serverSocket.accept();
                        socket.configureBlocking(false);
                        socket.register(selector, SelectionKey.OP_READ);
                        broadcast(socket, socket.getRemoteAddress().toString().substring(1) + " 已上线");
                    }else if (key.isReadable()) {
                        receiveMsg(key);
                    }else if (key.isWritable() && key.isValid()) {
                        SocketChannel socket = (SocketChannel) key.channel();
                        ByteBuffer buf = (ByteBuffer) key.attachment();
                        socket.write(buf);
                        key.interestOps(SelectionKey.OP_READ);
                    }
                    keys.remove();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
