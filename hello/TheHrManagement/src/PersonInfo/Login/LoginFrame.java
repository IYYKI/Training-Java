package PersonInfo.Login;

import PersonInfo.MenuFrame.MenuFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LoginFrame extends JFrame {
    Container contentPane;
    JPanel paneTop = new JPanel();
    JPanel paneMid = new JPanel();
    JPanel paneBut = new JPanel();
    JLabel Top = new JLabel();
    JLabel Names = new JLabel();
    JLabel Pwd = new JLabel();
    JLabel Model = new JLabel();
    JLabel Null = new JLabel();
    JTextField Namefield = new JTextField(15);
    JPasswordField Pwdfield = new JPasswordField(15);
    JComboBox cmb = new JComboBox();
    JButton button2 = new JButton("ȡ��");
    JButton button1 = new JButton("��¼");
    int ss;

    LoginFrame() {
        Names.setText("ְ����:");
        Pwd.setText("��    ��:");
        Model.setText("�û���:");
        Null.setText("          ");
        String[] s1 = {"����Ա", "һ���û�"};
        cmb.addItem(s1[0]);
        cmb.addItem(s1[1]);
        paneTop.add(Names);
        paneTop.add(Namefield);
        paneMid.add(Pwd);
        paneMid.add(Pwdfield);
        paneMid.add(Model);
        paneMid.add(cmb);
        paneBut.add(button1);
        paneBut.add(button2);
        contentPane = this.getContentPane();
        contentPane.add(paneTop, BorderLayout.NORTH);
        contentPane.add(paneMid, BorderLayout.CENTER);
        contentPane.add(paneBut, BorderLayout.SOUTH);
        setTitle("��ӭ��¼");
        setSize(260, 170);
//�����ڷ���������        
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
        public void actionPerformed(ActionEvent e) {
            ss = cmb.getSelectedIndex();

        }
    }

    public class ButtonHandle implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (ss) {
                case 0:
                    administer();
                    break;
                case 1:
                    commonclass();
                    break;
            }
        }

        public void administer() {
            String str1, str2;
            str1 = Namefield.getText();
            str2 = new String(Pwdfield.getPassword());
            try {

                if (str1.equals("") || str2.equals("")) {
                    JOptionPane.showMessageDialog(null, "������ְ���ź����룡");
                    return;
                }
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:odbc:redsun", "", "");
                PreparedStatement stmt = conn.prepareStatement("select * from ϵͳ�û� where ְ����=? and ����=?");
                stmt.setString(1, str1);
                stmt.setString(2, str2);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "��¼�ɹ�!", "��ӭ��¼���¹���ϵͳ", JOptionPane.INFORMATION_MESSAGE);
                    MenuFrame o = new MenuFrame();
                    o.go();
                } else {
                    JOptionPane.showMessageDialog(null, "��ϵͳ�û�,����!", "��¼ʧ��", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("�޴��û�,����!");
                }
            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void commonclass(){
            String str1, str2;
            str1 = Namefield.getText();
            str2 = new String(Pwdfield.getPassword());
            try {
                if (str1.equals("") || str2.equals("")) {
                    JOptionPane.showMessageDialog(null, "������ְ���ź����룡");
                    return;
                }
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conn = DriverManager.getConnection("jdbc:odbc:redsun", "", "");
                PreparedStatement stmt = conn.prepareStatement("select * from ϵͳ�û� where ְ����=? and ����=?");
                stmt.setString(1, str1);
                stmt.setString(2, str2);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "��¼�ɹ�!", "��ӭ��¼���¹���ϵͳ", JOptionPane.INFORMATION_MESSAGE);
                    MenuFrame o = new MenuFrame();
                    o.go();

                } else {
                    JOptionPane.showMessageDialog(null, "��ϵͳ�û�,����!", "��¼ʧ��", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("�޴��û�,����!");
                }

            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new LoginFrame();
    }
}