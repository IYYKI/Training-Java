package TELLROOM.TellRoom;

import TELLROOM.server.Server;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *服务器发送通知的线程类
 * @author VastWu
 *
 */
public class TellThread extends Thread{
    private Socket socket;
    public TellThread(Socket socket) {
        this.socket=socket;
    }
    @Override
    public void run() {
        try {
            OutputStream ops=socket.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(ops);
            BufferedWriter bw=new BufferedWriter(osw);
            String address=socket.getRemoteSocketAddress().toString();
            bw.write("欢迎"+address+"来到聊天室\n");
            bw.write("当前在线人数："+Server.socketList.size()+"人\r\n");
            bw.flush();
            for(Socket sk:Server.socketList) {
                if(sk!=socket) {
                    OutputStream ops2=sk.getOutputStream();
                    OutputStreamWriter osw2=new OutputStreamWriter(ops2);
                    BufferedWriter bw2=new BufferedWriter(osw2);
                    bw2.write(address+"进入了聊天室，当前在线人数："+ Server.socketList.size()+"人\r\n");
                    bw2.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}