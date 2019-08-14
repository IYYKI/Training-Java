package WotkThree;

import javax.swing.*;
import java.awt.*;

public class Change {
    private JTextField textField;

    public Change() {
        textField = new JTextField(15);
        textField.setText("");
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(String string) {
        this.textField.setText(string);
    }

    public static void main(String[] args) {
        Change one = new Change();
        Change two = new Change();
        one.jF(600, "", one, two);
        two.jF(1000, "", two, one);

    }

    public void jF(int x, String str, Change one, Change two) {
        JFrame jf = new JFrame();
        jf.setBounds(x, 300, 230, 200);
        Container container = jf.getContentPane();
        container.setLayout(new FlowLayout());
        JButton b = new JButton("转移");
        MyListener mListener = new MyListener(one, two);
        b.addActionListener(mListener);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.add(one.textField);
        container.add(b);
    }
}


