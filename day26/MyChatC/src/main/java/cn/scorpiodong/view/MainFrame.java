package cn.scorpiodong.view;

import cn.scorpiodong.controller.TcpComm;
import cn.scorpiodong.model.Command;
import cn.scorpiodong.model.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * MyChatC - MainFrame
 *
 * @author ScorpioDong
 * @version 1.0
 * @date 2020/3/7 2:00 下午
 */
public class MainFrame extends JFrame {
    private JTextArea recvTextArea;
    private JTextArea sendTextArea;
    private JButton sendButton;
    private JList<String> memberOnlineList;
    private DefaultListModel<String> membersOnline;
    private JLabel countOnlineLabel;
    private TcpComm comm;
    private SwingWorker<String, Object> task;
    private String userName;
    private int countOnline = 0;

    public MainFrame() {
        super("MyChat");
        setSize(800, 640);
        init();

        initAction();

        showConfigDialog(this, this);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    /**
     * 初始化UI
     */
    private void init() {
        // 接收框
        recvTextArea = new JTextArea(20, 30);
        recvTextArea.setEditable(false);
        recvTextArea.setBackground(new Color(27, 20, 37));
        recvTextArea.setForeground(new Color(255, 255, 255));
        recvTextArea.setFont(new Font("Dialog", Font.PLAIN, 16));

        // 发送框
        sendTextArea = new JTextArea(5, 30);
        sendTextArea.setFont(new Font("Dialog", Font.PLAIN, 16));
        sendTextArea.setBounds(0, 640 / 10 * 7, 760 / 4 * 3, 640 / 10 * 2);

        // 发送按钮
        sendButton = new JButton("发送");
        sendButton.setBounds(760 / 4 * 3 - 100, 640 - 62, 100, 30);

        // 在线成员列表
        memberOnlineList = new JList<>();
        membersOnline = new DefaultListModel<>();
        memberOnlineList.setModel(membersOnline);
        memberOnlineList.setBackground(new Color(200, 200, 200));

        // 在线人数标签
        countOnlineLabel = new JLabel("在线人数：" + countOnline);
        countOnlineLabel.setBounds(760 / 4 * 3 + 10, 0, 800 - 760 / 4 * 3, 40);

        JScrollPane recvPane = new JScrollPane(recvTextArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        recvPane.setBounds(0, 0, 760 / 4 * 3, 640 / 10 * 7);

        JScrollPane listPane = new JScrollPane(memberOnlineList,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        listPane.setBounds(760 / 4 * 3 + 10, 40, 800 - 760 / 4 * 3 - 20, 640 - 80);

        Panel root = new Panel(null);
        root.add(recvPane);
        root.add(sendTextArea);
        root.add(sendButton);
        root.add(countOnlineLabel);
        root.add(listPane);
        setContentPane(root);
    }

    /**
     * 初始化各个组件的事件
     */
    private void initAction() {
        // 发送按钮事件
        sendButton.addActionListener((e) -> {
            invoke(() -> {
                sendMessage();
            });
        });

        sendTextArea.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (e.getModifiers() == InputEvent.CTRL_MASK) {
                        sendTextArea.append("\n");
                    } else {
                        sendMessage();
                    }
                }
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                comm.write(new Command("close", userName));
                comm.dispose();
                super.windowClosing(e);
            }
        });
    }

    /**
     * 消息发送
     */
    private void sendMessage() {
        Message msg = new Message();
        msg.setName(userName);
        msg.setAddress("127.0.0.1");
        msg.setTime(System.currentTimeMillis());
        msg.setData(sendTextArea.getText());
        comm.write(new Command("data", msg));
        sendTextArea.setText("");
    }

    /**
     * 初始化网络通信
     *
     * @param ip   IPv4地址
     * @param port 端口
     * @return 成功返回true
     */
    private boolean initSocket(String ip, int port) {
        try {
            comm = new TcpComm(ip, port);
            task = new SwingWorker<String, Object>() {
                @Override
                protected String doInBackground() throws Exception {
                    while (true) {
                        comm.read((cmd) -> {
                            if ("data".equals(cmd.getKey())) {
                                writeToRecvTextArea((Message) cmd.getValue());
                            } else if("addUser".equals(cmd.getKey())) {
                                addMemberOnline((String) cmd.getValue());
                            } else if("delUser".equals(cmd.getKey())) {
                                delMemberOnline((String) cmd.getValue());
                            }
                            Thread.sleep(200);
                        });
                    }
                }
            };
            task.execute();
            comm.write(new Command("ready", userName));
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * 添加在线成员
     *
     * @param name 成员名
     */
    private void addMemberOnline(String name) {
        countOnline++;
        invoke(() -> {
            countOnlineLabel.setText("在线人数：" + countOnline);
            membersOnline.addElement(name);
            memberOnlineList.setModel(membersOnline);
        });
    }

    /**
     * 删除在线成员
     *
     * @param name 成员名
     */
    private void delMemberOnline(String name) {
        countOnline--;
        invoke(() -> {
            countOnlineLabel.setText("在线人数：" + countOnline);
            membersOnline.removeElement(name);
            memberOnlineList.setModel(membersOnline);
        });
    }

    /**
     * 将数据写入接收框
     *
     * @param msg
     */
    private void writeToRecvTextArea(Message msg) {
        String name = msg.getName();
        String ip = msg.getAddress();
        String data = msg.getData().replace("\n", "\n    ");
        String time = new SimpleDateFormat("HH:mm:ss").format(msg.getTime());
        invoke(() -> {
            recvTextArea.append(name);
            recvTextArea.append(" @ " + ip);
            recvTextArea.append("    " + time);
            recvTextArea.append("\n    " + data + "\n\n");
        });
    }

    /**
     * UI相关任务执行方法
     *
     * @param doRun 要执行的UI相关的任务(非耗时任务)
     */
    public static void invoke(Runnable doRun) {
        SwingUtilities.invokeLater(doRun);
    }

    /**
     * 显示开始配置界面
     *
     * @param owner           所有者
     * @param parentComponent 父组件
     */
    private static void showConfigDialog(Frame owner, Component parentComponent) {
        // 创建一个模态对话框
        final JDialog dialog = new JDialog(owner, "开始", true);
        // 设置对话框的宽高
        dialog.setSize(300, 200);
        // 设置对话框大小不可改变
        dialog.setResizable(false);
        // 设置对话框相对显示的位置
        dialog.setLocationRelativeTo(parentComponent);

        JLabel addressLabel = new JLabel("地址: ");
        JLabel nameLabel = new JLabel("昵称: ");

        JTextField address = new JTextField("182.61.3.51:60000");
        JTextField name = new JTextField("");

        // 创建一个按钮用于关闭对话框
        JButton okBtn = new JButton("确定");

        Box addressBox = Box.createHorizontalBox();
        addressBox.add(addressLabel);
        addressBox.add(address);

        Box nameBox = Box.createHorizontalBox();
        nameBox.add(nameLabel);
        nameBox.add(name);

        Box bottomBox = Box.createHorizontalBox();
        bottomBox.add(Box.createHorizontalGlue());
        bottomBox.add(okBtn);

        Box root = Box.createVerticalBox();
        root.add(nameBox);
        root.add(Box.createVerticalStrut(10));
        root.add(addressBox);
        root.add(Box.createVerticalStrut(10));
        root.add(bottomBox);
        root.setBounds(50, 50, 200, 100);
        // 创建对话框的内容面板, 在面板内可以根据自己的需要添加任何组件并做任意是布局
        JPanel panel = new JPanel(null);

        panel.add(root);

        // 事件
        okBtn.addActionListener((e) -> {
            if ("".equals(name.getText())) {
                JOptionPane.showMessageDialog(
                        dialog,
                        "请输入昵称！",
                        "昵称为空",
                        JOptionPane.WARNING_MESSAGE
                );
            } else if (!address.getText().contains(":")) {
                JOptionPane.showMessageDialog(
                        dialog,
                        "请检查地址！",
                        "地址不正确",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                // TODO
                String userName = name.getText().trim();
                String ip = address.getText().split("\\:")[0];
                int port = Integer.parseInt(address.getText().split("\\:")[1]);
                ((MainFrame) owner).setUserName(userName);
                if (!((MainFrame) owner).initSocket(ip, port)) {
                    JOptionPane.showMessageDialog(
                            dialog,
                            "远程连接无响应，请确认地址！",
                            "连接失败",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }
                dialog.dispose();
            }
        });

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // 设置对话框的内容面板
        dialog.setContentPane(panel);
        // 显示对话框
        dialog.setVisible(true);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
