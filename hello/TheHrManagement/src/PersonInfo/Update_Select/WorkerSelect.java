package PersonInfo.Update_Select;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.*;
import java.util.Vector;

public class WorkerSelect extends JFrame {
    Container c;
    JPanel panel1, panel2, panel3;
    JLabel WnoLabel;
    JTextField WTextField;
    JButton Btnselect;
    JTable table = null;
    DefaultTableModel defaultModel = null;

    public WorkerSelect() {
        super("查询职工信息");
        c = getContentPane();
        c.setLayout(new BorderLayout());
        WnoLabel = new JLabel("职工号:", JLabel.CENTER);
        WTextField = new JTextField(15);
        Btnselect = new JButton("查询");
        panel1 = new JPanel();
        panel3 = new JPanel();
        panel1.add(WnoLabel);
        panel1.add(WTextField);
        panel3.add(Btnselect);
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
        c.add(panel2, BorderLayout.SOUTH);
        pack();
        this.setSize(740, 500);
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

                    } else {
                        str = str1 + " where 职工号='" + WTextField.getText() + "'";
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
                    }
                } catch (SQLException e) {
                    System.out.println("SQLException: " + e.getMessage());
                }
            }
        });
    }

    private JPanel createTopPane() {
        JPanel pane = new JPanel(new FlowLayout());
        pane.setBorder(new EmptyBorder(10, 10, 10, 10));
        pane.add(WnoLabel);
        pane.add(WTextField);
        pane.add(Btnselect);
        return pane;
    }

    public static void main(String[] args) {
        new WorkerSelect();
    }
}