package PersonInfo.Update_Select;

import PersonInfo.SubmitAll.Submit1;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class WorkerUpdate extends JFrame {
    Container c;

    JPanel panel1,panel2,panel3,panel4;

    JLabel Labno,Labname,Labaddress,Labphoneno,Labdepart,Labsalary,Labtime,Laboccup;

    JTextField Wno,Wname,Waddress,Wphoneno,Wdepart,Wsalary,Wtime,Woccup;

    JButton Btnopen,Btnupdate;

    JTable table = null;

    DefaultTableModel defaultModel = null;

    public WorkerUpdate(){
        super("修改员工信息");
        c = getContentPane();
        c.setLayout(new BorderLayout());
        Labno = new JLabel("员工号",JLabel.CENTER);
        Labname = new JLabel("姓名",JLabel.CENTER);
        Labaddress = new JLabel("地址",JLabel.CENTER);
        Labphoneno = new JLabel("电话",JLabel.CENTER);
        Labdepart = new JLabel("部门",JLabel.CENTER);
        Labsalary = new JLabel("工资",JLabel.CENTER);
        Labtime = new JLabel("工龄",JLabel.CENTER);
        Laboccup = new JLabel("职务",JLabel.CENTER);

        Wno = new JTextField(15);
        Wname = new JTextField(15);
        Waddress = new JTextField(15);
        Wphoneno = new JTextField(15);
        Wdepart = new JTextField(15);
        Wsalary = new JTextField(15);
        Wtime = new JTextField(15);
        Woccup = new JTextField(15);

        Btnopen = new JButton("打开");
        Btnupdate = new JButton("修改");

        String  [] n = {"员工号","姓名","地址","电话","部门","工资","工龄","职务"};
        String  [] [] data = new String[0][0];
        defaultModel = new DefaultTableModel(data,n);
        table = new JTable(defaultModel);
        table.setPreferredScrollableViewportSize(new Dimension(700,240));
        JScrollPane s = new JScrollPane(table);
        panel2 = new JPanel();
        panel2.add(s);
        c.add(BorderLayout.NORTH,createRootPane());
        c.add(BorderLayout.CENTER,createRootPane());
        c.add(BorderLayout.SOUTH,panel2);
        pack();
        this.setSize(740,500);
        setVisible(true);
        Btnopen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ex) {
                try{
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                }catch (java.lang.ClassNotFoundException e){
                    System.out.println("ForName:"+e.getMessage());
                }
                String Workerno = Wno.getText();
                String str = null;
                String str1 = "select 员工号,姓名,地址,电话,部门,工资,工龄,职务 from 员工信息";
                try{
                    if (Workerno.equals("")){
                        str=str1;
                    }else {
                        str = str1+" where 职工号='"+Wno.getText()+"'";
                    }
                    Connection con = DriverManager.getConnection("jdbc:odbc:redsun");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(str);
                    while (rs.next()){
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
                }catch (SQLException e){
                    System.out.println("SQLException:"+e.getMessage());
                }
            }
        });
        Btnupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Submit1 o = new Submit1();
                    if (Wname.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"姓名不能为空",
                                "添加",JOptionPane.WARNING_MESSAGE);
                    }else {
                        o.tijiao(Wno.getText().toString(),Wname.getText().toString(),
                                Waddress.getText().toString(),Wphoneno.getText().toString(),
                                Wdepart.getText().toString(),Wsalary.getText().toString(),
                                Wtime.getText().toString(),Woccup.getText().toString());
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }JOptionPane.showMessageDialog(null,"修改成功",
                        "修改成功提示",JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
    private JPanel caeateTopPane(){
        JPanel panel = new JPanel(new GridLayout(4,4,5,5));
        panel.setBorder(new EmptyBorder(20,20,20,20));
        panel.add(Labno);
        panel.add(Wno);
        panel.add(Labdepart);
        panel.add(Wdepart);
        panel.add(Labname);
        panel.add(Wname);
        panel.add(Labsalary);
        panel.add(Wsalary);
        panel.add(Labaddress);
        panel.add(Waddress);
        panel.add(Labtime);
        panel.add(Wtime);
        panel.add(Labphoneno);
        panel.add(Wphoneno);
        panel.add(Laboccup);
        panel.add(Woccup);
        return panel;
    }
    private JPanel createBtnPane(){
        JPanel pane = new JPanel(new FlowLayout());
        pane.setBorder(new EmptyBorder(5,5,5,5));
        pane.add(Btnopen);
        pane.add(Btnupdate);
        return pane;
    }

    public static void main(String[] args) {
        new WorkerUpdate();
    }
}
