package TellRoom;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket server=new ServerSocket(8888);
        ArrayList<Socket> al=new ArrayList<>();
        while(true) {
            Socket s = server.accept();
            al.add(s);

            new ServerThread(s, al).start();
        }

    }

}

class ServerThread extends Thread{
    Socket s;
    ArrayList<Socket> al;

    public ServerThread(Socket s, ArrayList<Socket> al) {
        super();
        this.s = s;
        this.al = al;
    }

    @Override
    public void run() {

        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            while(true) {
                String str= br.readLine();

                for(Socket ss:al) {

                    PrintWriter pw=new PrintWriter(ss.getOutputStream());
                    pw.println(str);
                    pw.flush();
//					pw.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
