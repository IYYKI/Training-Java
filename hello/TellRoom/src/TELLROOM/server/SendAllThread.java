package TELLROOM.server;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 给所有客户端发消息的线程类
 * @author VastWu
 *
 */
public class SendAllThread extends Thread{
    @Override
    public void run() {
        try {
            //服务器控制台发送消息
            Scanner scan=new Scanner(System.in);
            //因为要发多条消息，所以用死循环
            while(true) {
                //接收输入的一行消息
                String msg=scan.nextLine();
                //使用输出流进行处理，并且需要向所有用户发消息所以需要对集合进行循环发送
                for(Socket socket:Server.socketList) {
                    OutputStream ops=socket.getOutputStream();
                    OutputStreamWriter osw=new OutputStreamWriter(ops);
                    BufferedWriter bw=new BufferedWriter(osw);
                    bw.write("服务器说："+msg+"\n");
                    bw.flush();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}