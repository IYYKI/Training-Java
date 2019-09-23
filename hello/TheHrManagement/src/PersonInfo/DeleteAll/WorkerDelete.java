package PersonInfo.DeleteAll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.Vector;

public class WorkerDelete extends JFrame {
    Container c;
    JPanel panel2;
    JLabel WnoLabel;
    JTextField WTextField;
    JButton Btnselect, Btndelete;
    JTable table = null;
    DefaultTableModel defaultModel = null;

    public WorkerDelete() {
        super("删除职工信息");
        c = getContentPane();
        c.setLayout(new BorderLayout());
        WnoLabel = new JLabel("职工号:");
        WTextField = new JTextField(15);
        Btnselect = new JButton("显示所有职工");
        Btndelete = new JButton("删除");
        String[] n = {"职工号", "姓名", "地址", "电话", "部门", "工资", "参加工作时间", "职务"};
        String[][] data = new String[0][0];
        defaultModel = new DefaultTableModel(data, n);
        table = new JTable(defaultModel);
        table.setPreferredScrollableViewportSize(new Dimension(700, 350));
        JScrollPane s = new JScrollPane(table);
        panel2 = new JPanel();
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel2.add(s);
        c.add(BorderLayout.NORTH, createTopPane());
        c.add(BorderLayout.SOUTH, panel2);
        pack();
        this.setSize(740, 520);
        setVisible(true);
        Btnselect.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

                } catch (java.lang.ClassNotFoundException e) {
                    System.out.println("ForName :" + e.getMessage());
                }

                String Wno = WTextField.getText();
                String str = null;
                String str1 = "select 职工号,姓名,地址,电话,部门,工资,参加工作时间,职务 from 员工信息";
                try {
                    if (Wno.equals("")) {
                        str = str1;
                    }
                    //str=str1+" where 职工号='"+WTextField.getText()+"'";
                    Connection con = DriverManager.getConnection("jdbc:odbc:redsun");
                    Statement stmt = con.createStatement();
                    System.out.println("*****连接数据库成功!");
                    ResultSet rs = stmt.executeQuery(str);
                    while (rs.next()) {
                        Vector data = new Vector();
                        data.addElement(rs.getString(1));
                        data.addElement(rs.getString(2));
                        data.addElement(rs.getString(3));
                        data.addElement(rs.getString(4));
                        data.addElement(rs.getString(5));
                        data.addElement(rs.getString(6));
                        data.addElement(rs.getString(7));
                        data.addElement(rs.getString(8));
                        defaultModel.addRow(data);
                    }
                    table.revalidate();
                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                }
            }
        });
        Btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                try {
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

                } catch (java.lang.ClassNotFoundException e) {
                    System.out.println("ForName :" + e.getMessage());
                }
                String Wno = WTextField.getText();
                String str = null;
                try {
                    if (Wno.equals("") || Wno == null) {
                        JOptionPane.showMessageDialog(null, "职工号不能为空", "消息提示", JOptionPane.WARNING_MESSAGE);
                    } else {
                        str = "DELETE  From  员工信息" + " where 职工号='" + WTextField.getText() + "'";
                        Connection con = DriverManager.getConnection("jdbc:odbc:redsun");
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(str);
                        JOptionPane.showMessageDialog(null, "删除成功!", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                }
            }
        });
    }

    private JPanel createTopPane() {
        JPanel pane = new JPanel(new BorderLayout());
        pane.setBorder(new EmptyBorder(5, 5, 5, 5));
        JPanel top = new JPanel(new FlowLayout());
        pane.add(BorderLayout.NORTH, top);
        top.add(WnoLabel);
        top.add(WTextField);
        pane.add(BorderLayout.SOUTH, createBtnPane());
        return pane;
    }

    private JPanel createBtnPane() {
        JPanel pane = new JPanel(new FlowLayout());
        pane.add(Btnselect);
        pane.add(Btndelete);
        return pane;
    }

    public static void main(String[] args) {
        new WorkerDelete();
    }
}
