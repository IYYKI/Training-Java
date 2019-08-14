package TELLROOM.cient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CientUtil {
    private Socket socket;
    public SendUtil su;
    public static void main(String[] args) {
        CientUtil cientUI=new CientUtil();
        cientUI.init();
    }
    //连接服务器的方法
    public Socket connection() {
        try {
            //尝试连接服务器
            Socket socket=new Socket("192.168.0.104", 8888);
            return socket;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void init() {
        JFrame jframe=new JFrame("姚氏洗脚城");
        jframe.setSize(700, 500);
        jframe.setDefaultCloseOperation(3);
        jframe.setLayout(null);
        //设置界面居中
        jframe.setLocationRelativeTo(null);
        //设置最大化按钮不可用
        jframe.setResizable(false);
        //历史消息框、并且添加滚动条
        JTextArea historyMsg=new JTextArea();
        JScrollPane jsp=new JScrollPane(historyMsg);
        jsp.setBounds(5, 25, 685, 300);
        historyMsg.setEditable(false);
        jframe.add(jsp);
        //发送消息框
        JTextArea sendMsg=new JTextArea();
        JScrollPane jsp2=new JScrollPane(sendMsg);
        jsp2.setBounds(5, 325, 600, 140);
        jframe.add(jsp2);
        //按钮
        JButton sendBut=new JButton("发送");
        JButton clearBut=new JButton("清空");
        JButton connectBut=new JButton("连接服务器");
        sendBut.setBounds(605, 364, 84, 100);
        clearBut.setBounds(605, 325, 84, 40);
        connectBut.setBounds(5, 1, 150, 22);
        jframe.add(connectBut);
        jframe.add(sendBut);
        jframe.add(clearBut);
        //给按钮添加监听器
        ActionListener al=new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String command=e.getActionCommand();
                switch (command) {
                    case "发送":
                        if(socket!=null) {
                            String msg=sendMsg.getText().trim();
                            sendMsg.setText("");
                            historyMsg.append("我说："+msg+"\r\n");
                            //调用方法发送出去
                            su.send(msg);
                        }
                        break;
                    case "清空":
                        sendMsg.setText("");
                        break;
                    case "连接服务器":
                        socket=CientUtil.this.connection();
                        if(socket==null) {
                            JOptionPane.showMessageDialog(null, "连接失败，请检查网络或重新连接！");
                        }else {
                            connectBut.setText("已连接服务器");
                            JOptionPane.showMessageDialog(null, "连接成功！");
                            //启动线程并且给服务器发送消息
                            ReceiveThread rt=new ReceiveThread(socket, historyMsg);
                            rt.start();
                            su=new SendUtil(socket);
                        }
                        break;

                    default:
                        break;
                }

            }
        };
        connectBut.addActionListener(al);
        sendBut.addActionListener(al);
        clearBut.addActionListener(al);
        jframe.setVisible(true);
    }
}