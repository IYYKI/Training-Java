package TELLROOM.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 转发客服端发送过来的消息的线程类
 * @author VastWu
 *
 */
public class TurnSendThread extends Thread {
    private Socket socket;
    private String address;

    //先使用构造方法把socket传过来
    public TurnSendThread(Socket socket) {
        this.socket = socket;
        //客户端的地址
        address = socket.getRemoteSocketAddress().toString();
    }

    @Override
    public void run() {
        try {
            InputStream ips = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(isr);
            while (true) {
                String str = br.readLine();
                //将读到的消息发送给所有的客户端
                for (Socket sk : Server.socketList) {
                    if (sk != socket) {
                        OutputStream ops = sk.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(ops);
                        BufferedWriter bw = new BufferedWriter(osw);
                        bw.write(str + "\n");
                        bw.flush();
                    }
                }
            }
        } catch (Exception e) {
            // 如果抛出异常，说明连接已经断开,此处为处理用户离开时通知其他客户端的功能
            // 从List中删除该客户端,并通知其他客户端
            Server.socketList.remove(this.socket);
            for (Socket sk : Server.socketList) {
                try {
                    // 从sk上获得输出流
                    OutputStream ops = sk.getOutputStream();
                    OutputStreamWriter osw = new OutputStreamWriter(ops);
                    BufferedWriter bw = new BufferedWriter(osw);

                    bw.write(address + "离开了房间!!\n");
                    bw.flush();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}