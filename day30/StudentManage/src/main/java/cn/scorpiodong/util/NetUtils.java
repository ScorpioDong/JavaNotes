package cn.scorpiodong.util;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * StudentManage - NetUtils
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/14 10:29 PM
 */
public class NetUtils {

    public static void send(SocketChannel socket, String msg) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(msg.getBytes());
        buf.flip();
        socket.write(buf);
        buf.clear();
    }
}
