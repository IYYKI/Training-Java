package MySwing;

import javax.swing.*;

public class JframeDemo {
    public static void main (String [] args){
        JFrame win = new JFrame("Hello");
        win.setSize(300,200);
        win.getContentPane().add(new JLabel("HI"));
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
