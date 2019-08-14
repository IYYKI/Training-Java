package TELLROOM.server;

import TELLROOM.TellRoom.TellThread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 服务器端
 * @author VastWu
 *
 */
public class Server {
    //声明一个集合用于储存socket对象
    public static ArrayList<Socket> socketList=new ArrayList<Socket>();
    //直接主方法以启动服务器
    public static void main(String[] args) throws Exception {
        //使用一个服务端套接字建立一个端口
        ServerSocket serverSocket=new ServerSocket(100);
        System.out.println("服务器开启成功，正在等待连接。。。");
        SendAllThread sat=new SendAllThread();
        sat.start();
        //为了使socket对象不被覆盖这里使用while死循环对socket进行储存
        while(true) {
            //等待连接
            Socket socket=serverSocket.accept();
            //连接成功后存入集合内
            socketList.add(socket);
            //得到客户端的地址
            String address=socket.getRemoteSocketAddress().toString();
            //连接成功后控制台提示连接成功
            System.out.println(address+"连接上来了");
            //启动转发线程
            TurnSendThread tst=new TurnSendThread(socket);
            tst.start();
            //启动通知线程
            TellThread tt=new TellThread(socket);
            tt.start();
        }

    }
}