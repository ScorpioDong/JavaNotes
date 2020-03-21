package cn.scorpio.chat.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Chat - ChatClient
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/16 9:06 下午
 */
public class ChatClient implements Runnable {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 20531;

    private SocketChannel socket;
    private Selector selector;

    public ChatClient() throws IOException, InterruptedException {
        socket = SocketChannel.open();
        selector = Selector.open();
        socket.configureBlocking(false);
        socket.register(selector, SelectionKey.OP_READ);
        if (!socket.connect(new InetSocketAddress(HOST, PORT))) {
            while (!socket.finishConnect()) {
                System.out.println("× 连接失败，2S后尝试重新连接...");
                Thread.sleep(2000);
            }
        }
        System.out.println("√ 网络已连接");
    }

    public void sendMsg(String msg) throws ClosedChannelException {
        ByteBuffer buf = ByteBuffer.wrap(msg.getBytes());
        socket.register(selector, SelectionKey.OP_WRITE, buf);
        selector.wakeup();
    }

    public void receiveMsg() throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(1024 * 4);
        int length = socket.read(buf);
        if (-1 == length) {
            System.out.println("您已下线！");
            socket.close();
            System.exit(0);
        }
        if (0 != length) {
            System.out.println(new String(buf.array(), 0, length));
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
                    if (key.isReadable()) {
                        receiveMsg();
                    }else if (key.isWritable() && key.isValid()) {
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
