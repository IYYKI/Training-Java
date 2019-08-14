package WotkThree;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class Test01
{
    public static void main(String[] args)
    {
        myFrame my = new myFrame("setvisible");
    }
}

class myFrame extends JFrame
{
    JTextArea show,input;
    JTextField host,sendpoint,receivepoint;
    JButton sure,send,filesend;
    public myFrame(String str)
    {
        super(str);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200, 200, 470, 570);
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        init();
        this.setVisible(true);
    }

    public void init()
    {
        show = new JTextArea(10,40);
        show.setLineWrap(true);
        show.setEditable(false);
        add(new JScrollPane(show));

        add(new JLabel("****目的ip地址:****"));
        host = new JTextField(30);
        add(host);

        add(new JLabel("*****目的端口:*****"));
        sendpoint = new JTextField(30);
        add(sendpoint);

        add(new JLabel("*****接收端口:*****"));
        receivepoint = new JTextField(30);
        add(receivepoint);
        sure = new JButton("确认端口设置");
        add(sure);
        sure.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String point = receivepoint.getText();
                if(point == null)
                {
                    return;
                }
                receive r = new receive(point);
                new Thread(r).start();

                receiveFile rf = new receiveFile();
                new Thread(rf).start();
            }
        });

        JButton save = new JButton("保存聊天记录");
        add(save);
        save.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser jfc = new JFileChooser("D:");
                String str = show.getText();
                jfc.showSaveDialog(save);
                File f = jfc.getSelectedFile();
                if(f == null)
                {
                    return;
                }
                try
                {
                    FileOutputStream out = new FileOutputStream(f);
                    out.write(str.getBytes(), 0, str.getBytes().length);
                    out.close();
                }catch(IOException e1){}
            }
        });


        JButton clear = new JButton("清屏");
        add(clear);
        clear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                show.setText("");
            }
        });


        input = new JTextArea(10,40);
        show.setLineWrap(true);
        add(new JScrollPane(input));

        input.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if(e.getKeyCode() == KeyEvent.VK_ENTER)
                {
                    String ip = host.getText();
                    String point = sendpoint.getText();
                    String message = input.getText();
                    send s = new send(ip, point, message);
                    new Thread(s).start();
                    input.setText("");
                }
            }
        });

        send = new JButton("发送");
        add(send);
        send.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String ip = host.getText();
                String point = sendpoint.getText();
                String message = input.getText();
                if(ip == null && point == null && message == null)
                {
                    return;
                }
                send s = new send(ip, point, message);
                new Thread(s).start();
                input.setText("");
            }
        });
        filesend = new JButton("发送文件");
        add(filesend);
        filesend.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFileChooser jfc = new JFileChooser("D:");
                jfc.showOpenDialog(filesend);
                String ip = host.getText();
                File f = jfc.getSelectedFile();
                sendFile sf = new sendFile(ip,f);
                new Thread(sf).start();
            }
        });


        JButton reset = new JButton("重置");
        add(reset);
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                input.setText("");
            }
        });
        JButton quit = new JButton("退出");
        add(quit);
        quit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
    }

    class receive implements Runnable
    {
        int point ;
        receive(String receivepoint)
        {
            this.point = Integer.parseInt(receivepoint);
        }
        public void run()
        {
            DatagramSocket ds = null ;
            DatagramPacket dp = null ;
            byte[] buf = new byte[8848];
            try
            {
                ds = new DatagramSocket(point);
                dp = new DatagramPacket(buf, buf.length);
            }catch(Exception e){}
            while(true)
            {
                if(ds == null)
                {
                    break;
                }else
                {
                    try
                    {
                        ds.receive(dp);
                        String message = new String(buf, 0, dp.getLength());
                        String ip = dp.getAddress().getHostAddress();
                        show.append(new Date().toLocaleString()
                                + "\n"
                                + ip
                                + "已接收:"
                                + "\t"
                                + message
                                + "\n"
                        );
                    }catch(IOException e)
                    {}
                }
            }
        }
    }
    class receiveFile implements Runnable
    {
        public void run()
        {
            DatagramSocket ds = null ;
            DatagramSocket ds1 = null ;
            DatagramPacket dp = null ;
            DatagramPacket dp1 = null ;
            FileOutputStream out = null;
            byte[] buf = new byte[88488];
            byte[] buf2 = new byte[100];
            try
            {
                ds = new DatagramSocket(9999);
                ds1 = new DatagramSocket(10000);
                dp = new DatagramPacket(buf, buf.length);
                dp1 = new DatagramPacket(buf2, buf2.length);
            }catch(Exception e){}
            while(true)
            {
                if(ds == null)
                {
                    break;
                }else
                {
                    try
                    {
                        ds1.receive(dp1);
                        String filename = new String(buf2,0,dp1.getLength());
                        File f = new File(filename);
                        f.createNewFile();

                        ds.receive(dp);
                        out = new FileOutputStream(f);
                        out.write(buf,0,dp.getLength());
                        String ip = dp.getAddress().getHostAddress();
                        show.append(new Date().toLocaleString()
                                + "\n"
                                + "已接收来自:"
                                + ip
                                + "的文件"
                                + "\n"
                        );
                    }catch(IOException e){}
                }
            }
        }
    }

    class send implements Runnable
    {
        String host ;
        int sendpoint;
        String message;
        send(String host , String sendpoint , String message)
        {
            this.host = host;
            this.sendpoint = Integer.parseInt(sendpoint);
            this.message = message;
        }
        public void run()
        {
            try
            {
                InetAddress ip = InetAddress.getByName(host);
                DatagramSocket ds = new DatagramSocket();
                DatagramPacket dp = new DatagramPacket(message.getBytes(), message.getBytes().length,ip,sendpoint);
                ds.send(dp);
                show.append(new Date().toLocaleString()
                        + "\n"
                        + "已发送:"
                        + "\t"
                        + message
                        + "\n"
                );
            }catch(IOException e){}
        }
    }
    class sendFile implements Runnable
    {
        String host ;
        File f ;
        sendFile(String host , File f)
        {
            this.host = host;
            this.f = f;
        }
        public void run()
        {
            try
            {
                InetAddress ip = InetAddress.getByName(host);
                byte[] fn = f.getName().getBytes();
                DatagramSocket filename = new DatagramSocket();
                DatagramPacket dp = new DatagramPacket(fn , fn.length , ip , 10000);
                filename.send(dp);

                FileInputStream in = new FileInputStream(f);
                byte[] buf = new byte[in.available()];
                DatagramSocket ds = new DatagramSocket();
                DatagramPacket dp1 = new DatagramPacket(buf , buf.length , ip , 9999);
                in.read(buf);
                ds.send(dp1);
                show.append(new Date().toLocaleString()
                        + "\n"
                        + "已成功发送一个文件"
                        + "\n"
                );
            }catch(IOException e){}
        }
    }
}