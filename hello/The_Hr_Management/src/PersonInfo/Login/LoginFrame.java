package PersonInfo.Login;

import PersonInfo.MenuFrame.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class LoginFrame extends JFrame {
    Container containerPane;
    JPanel panelTop = new JPanel();
    JPanel panelMid = new JPanel();
    JPanel panelBut = new JPanel();
    JLabel Top = new JLabel();
    JLabel Names = new JLabel();
    JLabel Pwd = new JLabel();
    JLabel Model = new JLabel();
    JLabel Null = new JLabel();
    JTextField Namefield = new JTextField(15);
    JPasswordField Pwdfield = new JPasswordField(15);
    JComboBox cmb = new JComboBox();
    JButton button1 = new JButton("登陆");
    JButton button2 = new JButton("取消");
    int ss;

    public LoginFrame() {
        Names.setText("职工号：");
        Pwd.setText("密 码：");
        Model.setText("用户：");
        Null.setText(" ");
        String[] s1 = {"管理员，游客"};
        cmb.addItem(s1[0]);
        cmb.addItem(s1[1]);
        panelTop.add(Names);
        panelTop.add(Namefield);
        panelMid.add(Pwd);
        panelMid.add(Pwdfield);
        panelMid.add(Model);
        panelMid.add(cmb);
        panelBut.add(button1);
        panelBut.add(button2);
        containerPane = this.getContentPane();
        containerPane.add(panelTop, BorderLayout.NORTH);
        containerPane.add(panelMid, BorderLayout.CENTER);
        containerPane.add(panelTop, BorderLayout.SOUTH);
        setTitle("欢迎登陆");
        setSize(260, 170);
        //将窗口设置在中间
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screen.width - getSize().width) / 2, (screen.height - getSize().height) / 2);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(new ButtonHandle());
        cmb.addActionListener(new GetSelected());
        button2.addActionListener(new Exit());
    }

    public class Exit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    public class GetSelected implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ss = cmb.getSelectedIndex();
        }
    }

    public class ButtonHandle implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (ss) {
                case 0:
                    addminister();
                    break;
                case 1:
                    commonclass();
                    break;
            }
        }

    }

    public void addminister() {
        String str1, str2;
        str1 = Namefield.getText();
        str2 = new String(Pwdfield.getPassword());
        try {
            if (str1.equals("") || str2.equals("")) {
                JOptionPane.showMessageDialog(null, "请输入ID和密码！");
                return;
            }

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:redsun", "", "");
            PreparedStatement stm = con.prepareStatement("select * form 系统用户 where 名字=? and 密码=?");
            stm.setString(1, str1);
            stm.setString(2, str2);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "登陆成功!",
                        "欢迎登陆人事管理系统", JOptionPane.INFORMATION_MESSAGE);
                MenuFrame o = new MenuFrame();
                o.go();
            } else {
                JOptionPane.showMessageDialog(null, "非系统用户，返回!",
                        "登陆失败", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("无此用户,返回！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void commonclass() {
        String str1, str2;
        str1 = Namefield.getText();
        str2 = new String(Pwdfield.getPassword());
        try {
            if (str1.equals("") || str2.equals("")) {
                JOptionPane.showMessageDialog(null, "请输入正确的职工号和密码！");
                return;
            }

            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con = DriverManager.getConnection("jdbc:odbc:redsun", "", "");
            PreparedStatement stm = con.prepareStatement("select * form 系统用户 where 名字=? and 密码=?");
            stm.setString(1, str1);
            stm.setString(2, str2);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "登陆成功!",
                        "欢迎登陆人事管理系统", JOptionPane.INFORMATION_MESSAGE);
                MenuFrame o = new MenuFrame();
                o.go();
            } else {
                JOptionPane.showMessageDialog(null, "非系统用户，返回!",
                        "登陆失败", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("无此用户,返回！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new LoginFrame();
    }
}
