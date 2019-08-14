package TELLROOM.cient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 发送消息的类
 * @author VastWu
 *
 */
public class SendUtil {
    private Socket socket;
    private BufferedWriter bw;
    private String add;
    public SendUtil(Socket socket) {
        this.socket=socket;
        try {
            OutputStream ops=socket.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(ops);
            bw=new BufferedWriter(osw);
            add=socket.getLocalSocketAddress().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void send(String msg) {
        try {
            bw.write(add+"说："+msg+"\r\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
