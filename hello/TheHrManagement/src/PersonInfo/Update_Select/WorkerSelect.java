package PersonInfo.Update_Select;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
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
        super("查询员工信息");
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
        String[] n = {"职工号", "姓名", "地址", "电话", "部门", "工资", "工龄", "职务"};
        String[][] data = new String[0][0];
        defaultModel = new DefaultTableModel(data, n);
        table = new JTable(defaultModel);
        table.setPreferredScrollableViewportSize(new Dimension(700, 350));
        JScrollPane s = new JScrollPane(table);
        panel2 = new JPanel();
        panel2.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel2.add(s);
        c.add(BorderLayout.NORTH, createRootPane());
        c.add(panel2, BorderLayout.SOUTH);
        pack();
        this.setSize(740, 500);
        Btnselect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Class.forName("sun.jdbc.obdc.JdbcOdbcDriver");
                } catch (java.lang.ClassNotFoundException ex) {
                    System.out.println("ForName:" + ex.getMessage());
                }
                String Wno = WTextField.getText();
                String str = null;
                String str1 = "select 职工号,姓名,地址,电话,部门,工资,工龄,职务 from 员工信息";
                try {
                    if (Wno.equals("")) {
                        str = str1;
                    } else {
                        str = str1 + "where 职工号='" + WTextField.getText() + "'";
                        Connection con = DriverManager.getConnection("jdbc:odbc:redsun");
                        Statement stmt = con.createStatement();
                        System.out.println("*******连接数据库成功");
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
                } catch (SQLException e1) {
                    System.out.println("SQLException:" + e1.getMessage());
                }
            }
        });
    }

    private JPanel careateTopPane() {
        JPanel pane = new JPanel(new FlowLayout());
        pane.setBorder(new EmptyBorder(10, 10, 10, 10));
        pane.add(WnoLabel);
        pane.add(WTextField);
        pane.add(Btnselect);
        return pane;
    }

}