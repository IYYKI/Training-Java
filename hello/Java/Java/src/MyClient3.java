
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.event.*;

public class MyClient3 extends JFrame implements ActionListener{
    JTextArea jta=null;
    JTextField jtf=null;
    JPanel jp1=null;
    JButton jb1=null;
    JScrollPane jsp=null;

    PrintWriter pw=null;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyClient3 mc=new MyClient3();
    }
    public MyClient3(){
        jta=new JTextArea();
        jsp=new JScrollPane(jta);
        jtf=new JTextField(20);
        jb1=new JButton("发送");
        jb1.addActionListener(this);

        jp1=new JPanel();
        jp1.add(jtf);
        jp1.add(jb1);
        this.add(jsp,"Center");
        this.add(jp1, "South");

        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("客户端");

        try {
            Socket s=new Socket("100.95.248.13", 9999);

            InputStreamReader isr=new InputStreamReader(s.getInputStream());
            BufferedReader br=new BufferedReader(isr);

            pw=new PrintWriter(s.getOutputStream(),true);
            while(true)
            {
                String info=br.readLine();
                jta.append("————————服务器————————\r\n"+info+"\r\n");
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource()==jb1)
        {
            String info=jtf.getText();

            //把客户端发送的信息追加到jta
            jta.append("————————客户端————————\r\n"+info+"\r\n");
            pw.println(":"+info);
            jtf.setText("");
        }
    }
}