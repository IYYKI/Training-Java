package PersonInfo.AddAll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WokerAdd extends JFrame {
    private JTextField Wno,Wname,Waddress,Wphoneno,Wdepart,
            Wsalary,Wtime,Woccup;
    private JLabel jno,jname,jaddress,jphoneno,jdepart,
            jtime,joccup, jsalary;
    private JButton button1,button2;
    JPanel pane = new JPanel(new BorderLayout());
   public WokerAdd(){
       this.setLayout(null);
       this.setTitle("添加新员工:");
       this.setSize(500,300);
       jno = new JLabel("员工号:");
       Wno = new JTextField();
       jname = new JLabel("姓名:");
       Wname = new JTextField();
       jaddress = new JLabel("地址:");
       Waddress = new JTextField();
       jphoneno = new JLabel("电话:");
       Wphoneno = new JTextField();
       jdepart = new JLabel("部门:");
       Wdepart = new JTextField();
       jsalary = new JLabel("工资:");
       Wsalary = new JTextField();
       jtime = new JLabel("工龄:");
       Wtime = new JTextField();
       joccup = new JLabel("职务:");
       Woccup = new JTextField();
       button1 = new JButton("添加");
       button2 = new JButton("取消");
       //设置标签大小
       jno.setBounds(30,15,60,30);
       jname.setBounds(30,50,60,30);
       jaddress.setBounds(30,85,60,30);
       jphoneno.setBounds(30,120,60,30);
       jdepart.setBounds(240,15,90,30);
       jsalary.setBounds(240,50,90,30);
       jtime.setBounds(240,85,90,30);
       joccup.setBounds(240,120,90,30);

       Wno.setBounds(100,15,120,30);
       Wname.setBounds(240,15,90,30);
       Waddress.setBounds(100,85,120,30);
       Wphoneno.setBounds(100,120,120,30);
       Wdepart.setBounds(340,15,120,30);
       Wsalary.setBounds(340,50,210,30);
       Wtime.setBounds(340,15,120,30);
       Woccup.setBounds(340,120,120,30);
       button1.setBounds(140,200,60,26);
       button2.setBounds(250,200,60,26);

       this.add(jno);
       this.add(Wno);
       this.add(jname);
       this.add(Wname);
       this.add(jaddress);
       this.add(Waddress);
       this.add(jphoneno);
       this.add(Wphoneno);
       this.add(jdepart);
       this.add(Wdepart);
       this.add(jsalary);
       this.add(Wsalary);
       this.add(jtime);
       this.add(Wtime);
       this.add(joccup);
       this.add(Woccup);

       this.add(button1);
       this.add(button2);

       button1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               try{
               Add o = new Add();
               if (Wno.getText().toString().equals("")) {
                   JOptionPane.showMessageDialog(
                           null, "职工号不能为空",
                           "添加", JOptionPane.WARNING_MESSAGE);
               } else if (Wname.getText().toString().equals("")) {
                   JOptionPane.showMessageDialog(
                           null, "姓名不能为空",
                           "添加", JOptionPane.WARNING_MESSAGE);
               } else if (Waddress.getText().toString().equals("")) {
                   JOptionPane.showMessageDialog(
                           null, "地址不能为空",
                           "添加", JOptionPane.WARNING_MESSAGE);
               } else if (Wphoneno.getText().toString().equals("")) {
                   JOptionPane.showMessageDialog(
                           null, "电话不能为空",
                           "添加", JOptionPane.WARNING_MESSAGE);
               } else if (Wname.getText().toString().equals("")) {
                   JOptionPane.showMessageDialog(
                           null, "部门不能为空",
                           "添加", JOptionPane.WARNING_MESSAGE);
               } else {
                   o.tianjia(Wno.getText().toString(), Wname.getText().toString(),
                           Waddress.getText().toString(), Wphoneno.getText().toString(),
                           Wdepart.getText().toString(), Wsalary.getText().toString(),
                           Wtime.getText().toString(), Woccup.getText().toString());

               }
           }catch (Exception e1){
                   e1.printStackTrace();
               }JOptionPane.showMessageDialog(null, "添加成功",
                       "添加成功提示",JOptionPane.INFORMATION_MESSAGE);
           }
       });
       button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Wno.setText("");
               Wname.setText("");
               Waddress.setText("");
               Wphoneno.setText("");
               Wdepart.setText("");
               Wsalary.setText("");
               Wtime.setText("");
               Woccup.setText("");
           }
       });
       setVisible(true);
   }

}
