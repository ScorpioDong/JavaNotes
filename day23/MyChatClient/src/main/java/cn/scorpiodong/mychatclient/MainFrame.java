package cn.scorpiodong.mychatclient;

import com.alibaba.fastjson.JSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;

/**
 * MyChatClient - MainFrame
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/4 9:02 下午
 */
public class MainFrame extends JFrame {
    private JTextArea recvTextArea;
    private JTextArea sentTextArea;
    private JTextField nameTextField;
    private JButton sendButton;
    private Socket socket;
    private InputStream reader;
    private OutputStream writer;

    public MainFrame() throws HeadlessException {
        super("MyChat");
        initFrame();
        initSocket();
        sendListener();
        windowListener();
    }

    private void initFrame() {
        setSize(760, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        recvTextArea = new JTextArea(20, 30);
        recvTextArea.setEditable(false);
        recvTextArea.setBackground(new Color(0x000000));
        recvTextArea.setForeground(new Color(0xFFFFFF));
        sentTextArea = new JTextArea(5, 30);
        nameTextField = new JTextField("UserName");
        sendButton = new JButton("发送");

        Box buttonBox = Box.createHorizontalBox();
        buttonBox.setMaximumSize(new Dimension(getWidth(), sendButton.getHeight() * 2));
        buttonBox.add(nameTextField);
        buttonBox.add(Box.createHorizontalStrut(500));
        buttonBox.add(sendButton);

        Box mainBox = Box.createVerticalBox();
        mainBox.add(recvTextArea);
        mainBox.add(sentTextArea);
        mainBox.add(buttonBox);

        setContentPane(mainBox);
        setVisible(true);
    }

    private void initSocket() {
        try {
            socket = new Socket(Config.ADDRESS, Config.PORT);
            reader = socket.getInputStream();
            writer = socket.getOutputStream();
            SwingUtilities.invokeLater(() -> {
                new Thread(() -> {
                    while (true) {
                        try {
                            byte[] buf = new byte[1024];
                            int length = reader.read(buf);
                            if (length > 0) {
                                String data = new String(buf, 0, length);
                                User user = JSON.parseObject(data, User.class);
                                String template = String.format("%s@%s    %s\n    %s\n\n",
                                        user.getName(),
                                        user.getIp(),
                                        new SimpleDateFormat("HH:mm:ss").format(user.getDate()),
                                        user.getData().replaceAll("\n", "\n    "));
                                recvTextArea.append(template);
                            }
                            Thread.sleep(100);
                        } catch (IOException | InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendListener() {
        sendButton.addActionListener((e) -> SwingUtilities.invokeLater(() -> {
            User user = new User();
            user.setName(nameTextField.getText().trim());
            user.setDate(System.currentTimeMillis());
            user.setData(sentTextArea.getText());
            try {
                byte[] buf = JSON.toJSONBytes(user);
                writer.write(buf, 0, buf.length);
                sentTextArea.setText("");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }));
    }

    private void windowListener() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                User user = new User();
                user.setCmd("close");
                try {
                    byte[] buf = JSON.toJSONBytes(user);
                    writer.write(buf, 0, buf.length);
                    sentTextArea.setText("");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                super.windowClosing(e);
            }
        });
    }
}
