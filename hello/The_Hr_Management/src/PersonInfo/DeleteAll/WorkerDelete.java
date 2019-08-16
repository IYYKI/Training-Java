package PersonInfo.DeleteAll;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class WorkerDelete extends JFrame {
    Container c;
    JPanel panel2;
    JLabel WnLabel;
    JTextField WTextField;
    JButton Btnselect, Btndelete;
    JTable table = null;
    DefaultTableModel defaultModel = null;

    WorkerDelete() {
        super("删除职工信息");
        c = getContentPane();
        c.setLayout(new BorderLayout());
        WnLabel = new JLabel("职工号");
        WTextField = new JTextField(15);
        Btnselect = new JButton("显示所有员工");
        Btndelete = new JButton("删除");
        String[] n = {"职工号", "姓名", "地址", "电话", "部门", "工资", "工龄", "职务"};
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
                try{
                    if (Wno.equals("")||Wno==null){
                        JOptionPane.showMessageDialog(null,"职工号不能为空!",
                                "消息提示",JOptionPane.WARNING_MESSAGE);
                    }else {
                        str = "DELETE From 员工信息 "+" where 职工号='"+WTextField.getText()+"'";
                        Connection con = DriverManager.getConnection("jdbc:odbc:redsun");
                        Statement stmt = con.createStatement();
                        stmt.executeQuery(str);
                        JOptionPane.showMessageDialog(null,"删除成功!",
                                "消息提示",JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch (SQLException e1 ){
                    System.out.println("SQLException:"+e1.getMessage());
                }
            }
        });
    }
    private JPanel createTopPane(){
        JPanel pane = new JPanel(new BorderLayout());
        pane.setBorder(new EmptyBorder(5,5,5,5));
        JPanel top = new JPanel(new FlowLayout());
        pane.add(BorderLayout.NORTH,top);
        top.add(WnLabel);
        top.add(WTextField);
        pane.add(BorderLayout.SOUTH,createTopPane());
        return pane;
    }
    private JPanel createBtnPane(){
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(Btnselect);
        panel.add(Btndelete);
        return panel;
    }

    public static void main(String[] args) {
        new WorkerDelete();
    }
}