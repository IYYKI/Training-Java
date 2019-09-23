package WotkThree.Transfer;

import WotkThree.Listenet.MyListener;

import javax.swing.*;
import java.awt.*;

public class Transfer {
    private JTextField jtf;
    private JButton btn;
    private JTextField jtf2;
    private JButton btn2;

    public Transfer() {
        //1
        JFrame jf = new JFrame("一号端口");
        Container con = jf.getContentPane();
        con.setLayout(new FlowLayout());
        //2
        JFrame jf2 = new JFrame("二号端口");
        Container con2 = jf2.getContentPane();
        con2.setLayout(new FlowLayout());

        //1
        jtf = new JTextField(17);
        con.add(jtf);
        //2
        jtf2 = new JTextField(17);
        con2.add(jtf2);

        MyListener ml = new MyListener(this);
        //1
        btn = new JButton("转移");
        btn.addActionListener(ml);
        con.add(btn);
        //2
        btn2 = new JButton("转移");
        btn2.addActionListener(ml);
        con2.add(btn2);

        //1
        jf.setVisible(true);
        jf.setSize(200, 200);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //2
        jf2.setVisible(true);
        jf2.setSize(200, 200);
        jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getJtf() {
        return jtf;
    }

    public void setJtf(JTextField jtf) {
        this.jtf = jtf;
    }

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }

    public JTextField getJtf2() {
        return jtf2;
    }

    public void setJtf2(JTextField jtf2) {
        this.jtf2 = jtf2;
    }

    public JButton getBtn2() {
        return btn2;
    }

    public void setBtn2(JButton btn2) {
        this.btn2 = btn2;
    }

}
