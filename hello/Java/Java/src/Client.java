import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket(InetAddress.getByName("192.168.0.104"),1111);
        InputStream in = client.getInputStream();
        byte [] buf = new byte[30];
        String str = new String(buf).trim();
        System.out.println(str);

        OutputStream out = client.getOutputStream();
        out.write("收到".getBytes());
        out.flush();


        client.close();
    }
}
