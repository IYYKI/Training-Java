package PersonInfo.Update_Select;

import PersonInfo.SubmitAll.Submit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.Vector;

public class UpdatePwdUserclass extends JFrame {
    Container c;
    JPanel panel1, panel2, panel3, panel4;
    JLabel WnoLabel, PwdLabel, UserClassLabel;
    JTextField WTextField, XTextField, X1TextField;
    JButton Btnopen, Btnupdate;
    JTable table = null;
    DefaultTableModel defaultModel = null;

    public UpdatePwdUserclass() {
        super("修改密码和权限");
        c = getContentPane();
        c.setLayout(new BorderLayout());
        WnoLabel = new JLabel("职工号:", JLabel.CENTER);
        PwdLabel = new JLabel("密码:", JLabel.CENTER);
        UserClassLabel = new JLabel("用户类:", JLabel.CENTER);
        WTextField = new JTextField(15);
        XTextField = new JTextField(15);
        X1TextField = new JTextField(15);
        Btnopen = new JButton("打开");
        Btnupdate = new JButton("修改");
        panel1 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel1.add(WnoLabel);
        panel4.add(PwdLabel);
        panel3.add(UserClassLabel);
        panel1.add(WTextField);
        panel4.add(XTextField);
        panel3.add(X1TextField);
        panel1.add(Btnopen);
        panel3.add(Btnupdate);
        String[] n = {"职工号", "密码", "用户类"};
        String[][] data = new String[0][0];
        defaultModel = new DefaultTableModel(data, n);
        table = new JTable(defaultModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 100));
        JScrollPane s = new JScrollPane(table);
        panel2 = new JPanel();
        panel2.add(s);
        c.add(panel1, BorderLayout.NORTH);
        c.add(panel3, BorderLayout.EAST);
        c.add(panel4, BorderLayout.WEST);
        c.add(panel2, BorderLayout.SOUTH);
        pack();
        setVisible(true);

        Btnopen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

                } catch (java.lang.ClassNotFoundException e) {
                    System.out.println("ForName :" + e.getMessage());
                }

                String Wno = WTextField.getText();
                String str = null;
                String str1 = "select 职工号,密码,用户类 from 系统用户";
                try {
                    if (Wno.equals("")) {
                        str = str1;
                    } else {
                        str = str1 + " where 职工号='" + WTextField.getText() + "'";
                    }
                    Connection con = DriverManager.getConnection("jdbc:odbc:redsun");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(str);
                    while (rs.next()) {
                        Vector data = new Vector();
                        data.addElement(rs.getString(1));
                        data.addElement(rs.getString(2));
                        data.addElement(rs.getString(3));
                        defaultModel.addRow(data);
                    }
                    table.revalidate();

                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                }
            }
        });
        Btnupdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Submit o = new Submit();
                    if (XTextField.getText().toString().equals(""))
                        JOptionPane.showMessageDialog(null, "密码不能为空", "添加", JOptionPane.WARNING_MESSAGE);
                    else
                        o.tijiao(WTextField.getText().toString(), XTextField.getText().toString(), X1TextField.getText().toString());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "修改成功!", "修改密码和权限", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        new UpdatePwdUserclass();
    }
}