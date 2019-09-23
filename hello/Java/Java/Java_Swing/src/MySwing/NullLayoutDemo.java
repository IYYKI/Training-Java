package MySwing;

import javax.swing.*;

/**
 *Frame(w:574,H:390)
 *
 * ​			    |- - Jpanel(W:568,H:357)
 *
 * ​				|- - JButton OK (x:369,y:327,w:92,h:21)
 *
 * ​				|- - JButton Cancel (x:466,y:327,w:92,h:21)
 **/

public class NullLayoutDemo {
    public static void main (String [] args){
        JFrame win = new JFrame("Null layout");
        win.setSize(574,390);
        JPanel content = new JPanel();
        content.setLayout(null);
        win.setContentPane(content);
        JButton OK = new JButton("OK");
        content.add(OK);
        OK.setLocation(369,327);
        OK.setSize(92,21);
        JButton cancel = new JButton("Cancel");
        content.add(cancel);
        cancel.setLocation(466,327);
        cancel.setSize(92,21);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}