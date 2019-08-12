package MySwing;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {
        JFrame jf  = new JFrame("边界布局");
        Container con = jf.getContentPane();
        con.setLayout(new BorderLayout());

        JButton e = new JButton("东");
        JButton w = new JButton("西");
        JButton s = new JButton("南");
        JButton n = new JButton("北");
        JButton c = new JButton("中");

        con.add(e,BorderLayout.EAST);
        con.add(w,BorderLayout.WEST);
        con.add(s,BorderLayout.SOUTH);
        con.add(n,BorderLayout.NORTH);
        con.add(c,BorderLayout.CENTER);
    }
}
