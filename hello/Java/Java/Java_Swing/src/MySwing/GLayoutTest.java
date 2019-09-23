package MySwing;

import javax.swing.*;
import java.awt.*;

public class GLayoutTest {
    public static void main(String[] args) {
        JFrame jf = new JFrame("?????");
        Container con = jf.getContentPane();
        con.setLayout(new GridLayout(3,2,5,6));
        for (int i = 1 ; i<= 10; i++){
            JButton button = new JButton("button"+i);
            con.add(button);
        }
        jf.setVisible(true);
        jf.setSize(300,300);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
