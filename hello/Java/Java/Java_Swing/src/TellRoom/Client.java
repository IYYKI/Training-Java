package TellRoom;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket s=new Socket(InetAddress.getByName("192.168.43.15"), 8888);
        String name = JOptionPane.showInputDialog("创建用户:");
        new ClientWindow(name, s);
    }

}
class ClientWindow{
    private Socket socket;

    public ClientWindow(String name,Socket socket){
        this.socket = socket;
        JFrame jf=new JFrame(name);
        Container con = jf.getContentPane();
        con.setLayout(new FlowLayout());


        JTextArea area = new JTextArea(10, 20);
        area.setEditable(false);
        JScrollPane pane=new JScrollPane(area);
        area.setLineWrap(true);
        con.add(pane);


        JTextField field = new JTextField(15);
        con.add(field);


        JButton btn=new JButton("发送");
        con.add(btn);


        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String msg = field.getText();
                try {
                    PrintWriter pw=new PrintWriter(socket.getOutputStream());
                    pw.println(jf.getTitle()+":"+msg);
                    pw.flush();
//					pw.close();
                    field.setText("");

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        jf.setVisible(true);
        jf.setSize(350, 350);


        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true) {
                String msg;
                msg = br.readLine();
                area.setText(area.getText()+"\n"+msg);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }
    }
}
