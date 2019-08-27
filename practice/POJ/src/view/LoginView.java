package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import listener.LoginListener;


/**
 *登录界面
 */
public class LoginView {
    private JFrame jframe; //登录窗口
    private JTextField jtf1; //用户名值
    private  JPasswordField jpf2; //密码值
    private JLabel error; //错误提示（设置内容）
    private JButton btn1; //登录
    private JButton btn2; //取消

    public LoginView() {
        jframe = new JFrame("登录");
        Container con = jframe.getContentPane();
        con.setLayout(new GridLayout(4,1));

        //用户名的文本
        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("用户名:");
        jtf1 = new JTextField(10);
        jp1.add(jl1);
        jp1.add(jtf1);
        con.add(jp1);

        //密码的文本
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("    密码:");
        jpf2 = new JPasswordField(10);
        jp2.add(jl2);
        jp2.add(jpf2);
        con.add(jp2);

        //提示信息
        JPanel jp3 = new JPanel();
        error = new JLabel();
        error.setForeground(Color.red);
        jp3.add(error);
        con.add(jp3);

        //按钮
        JPanel jp4 = new JPanel();
        btn1 = new JButton("登录");
        btn2 = new JButton("取消");
        jp4.add(btn1);
        jp4.add(btn2);
        con.add(jp4);

        LoginListener ll = new LoginListener(this);
        btn1.addActionListener(ll);
        btn2.addActionListener(ll);

        //窗口可见
        jframe.setVisible(true);
        //站点位置
        jframe.setLocation(500, 250);
        //窗口大小不可变
        jframe.setResizable(false);
        //窗口大小
        jframe.setSize(260,185);

        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JFrame getJframe() {
        return jframe;
    }
    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }
    public JTextField getJtf1() {
        return jtf1;
    }
    public void setJtf1(JTextField jtf1) {
        this.jtf1 = jtf1;
    }
    public JPasswordField getJpf2() {
        return jpf2;
    }
    public void setJpf2(JPasswordField jpf2) {
        this.jpf2 = jpf2;
    }
    public JLabel getError() {
        return error;
    }
    public void setError(JLabel error) {
        this.error = error;
    }
    public JButton getBtn1() {
        return btn1;
    }
    public void setBtn1(JButton btn1) {
        this.btn1 = btn1;
    }
    public JButton getBtn2() {
        return btn2;
    }
    public void setBtn2(JButton btn2) {
        this.btn2 = btn2;
    }

}
