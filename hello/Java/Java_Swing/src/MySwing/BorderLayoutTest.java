package MySwing;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame jf  = new JFrame("�߽粼��");
        Container con = jf.getContentPane();
        con.setLayout(new BorderLayout());

        JButton e = new JButton("��");
        JButton w = new JButton("��");
        JButton s = new JButton("��");
        JButton n = new JButton("��");
        JButton c = new JButton("��");

        con.add(e,BorderLayout.EAST);
        con.add(w,BorderLayout.WEST);
        con.add(s,BorderLayout.SOUTH);
        con.add(n,BorderLayout.NORTH);
        con.add(c,BorderLayout.CENTER);
    }
}
