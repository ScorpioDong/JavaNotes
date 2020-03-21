package cn.scorpiodong.controller;

import cn.scorpiodong.model.Command;
import cn.scorpiodong.view.MainFrame;

import java.io.*;
import java.net.Socket;

/**
 * MyChatC - TcpComm
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/7 4:57 下午
 */
public class TcpComm {
    private final Socket socket;
    private final OutputStream outputStream;
    private final InputStream inputStream;

    public TcpComm(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
    }

    public void read(Receive recv) {
        try {
            if (inputStream.available() > 0) {
                ObjectInput objectInput = new ObjectInputStream(inputStream);
                Command cmd = (Command) objectInput.readObject();
                recv.receiveProcess(cmd);
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            // e.printStackTrace();
        }
    }

    public void write(Command cmd) {
        try {
            ObjectOutput objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(cmd);
            objectOutput.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dispose() {
        try {
            outputStream.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
