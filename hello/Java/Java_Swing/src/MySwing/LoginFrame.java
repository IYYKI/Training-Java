package MySwing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LoginFrame extends JFrame {
    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.init();
        loginFrame.showView();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public LoginFrame() {
        init();
        showView();
    }
    /**
     * 界面初始化方法，绘制全部界面组件
     * **/
    private  void init(){
        setTitle("电大在线评测系统--登陆");
        setSize(300,200);
        //设置内容面板
        setContentPane(createContentPane());
    }
    private JPanel createContentPane(){
        JPanel pane = new JPanel(new BorderLayout());
        pane.setBorder(new EmptyBorder(12,12,12,12));
        pane.add(BorderLayout.NORTH,new JLabel("登陆系统",JLabel.CENTER));
        pane.add(BorderLayout.CENTER,createNamePwdPane());
        pane.add(BorderLayout.SOUTH,createBtnPane());
        return pane;
    }
    private JPanel createNamePwdPane(){
        JPanel pane = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new GridLayout(2,1,0,6));
        pane.add(BorderLayout.NORTH,top);
        top.add(createNamePane());
        top.add(createPwdPane());
        return pane;
    }
    private JPanel createNamePane(){
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(BorderLayout.WEST,new JLabel("编号："));
        pane.add(BorderLayout.CENTER,new JTextField());
        return pane;
    }
    private JPanel createPwdPane(){
        JPanel pane = new JPanel(new BorderLayout());
        pane.add(BorderLayout.WEST,new JLabel("密码："));
        pane.add(BorderLayout.CENTER,new JPasswordField());
        return pane;
    }
    private JPanel createBtnPane(){
        JPanel pane = new JPanel(new FlowLayout());
        JButton login = new JButton("登陆");
        JButton cancel = new JButton("取消");
        pane.add(login);
        pane.add(cancel);
        return pane;
    }
    /**
     * 界面显示方法
     * **/
    public void showView(){
        setVisible(true);
    }
}