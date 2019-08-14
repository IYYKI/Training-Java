package TELLROOM.cient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JTextArea;

/**
 * 接收来自服务器的线程类
 * @author VastWu
 *
 */
public class ReceiveThread extends Thread{
    private Socket socket;
    private JTextArea historyMsg;
    public ReceiveThread(Socket socket,JTextArea historyMsg) {
        this.socket=socket;
        this.historyMsg=historyMsg;
    }
    @Override
    public void run() {
        try {
            InputStream ips=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(isr);
            while(true) {
                String msg=br.readLine();
                historyMsg.append(msg+"\r\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}