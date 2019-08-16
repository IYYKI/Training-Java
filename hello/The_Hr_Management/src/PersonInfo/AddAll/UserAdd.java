package PersonInfo.AddAll;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserAdd extends JFrame {
    private JTextField Wno,Wpwd,Wuserclass;
    private JLabel jno, jpwd,juserclass;
    private JButton Btnupdate,Btnexit;
    public UserAdd(){
        this.setLayout(null);
        jno = new JLabel("职工号:");
        jpwd = new JLabel("密码:");
        juserclass = new JLabel("用户类");
        Wno = new JTextField();
        Wuserclass = new JTextField();
        Btnupdate = new JButton("添加");
        Btnexit = new JButton("取消");
        jno.setBounds(30,20,60,30);//设置标签大小
        jpwd.setBounds(30,70,60,26);
        juserclass.setBounds(30,120,60,26);
        Wno.setBounds(110,20,120,26);
        Wpwd.setBounds(110,70,120,26);
        Wuserclass.setBounds(110,120,120,26);
        Btnupdate.setBounds(30,220,60,26);
        Btnexit.setBounds(140,220,60,26);
        this.add(jno);
        this.add(Wno);
        this.add(jpwd);
        this.add(Wpwd);
        this.add(juserclass);
        this.add(Wuserclass);
        this.add(Btnupdate);
        this.add(Btnexit);
        this.setSize(250,300);
        this.setTitle("添加新用户");
        Btnupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Add1 o = new Add1();
                    if (Wno.getText().toString().equals("")){
                        JOptionPane.showMessageDialog(null,"职工号不能为空!",
                                "添加",JOptionPane.WARNING_MESSAGE);
                    }else if (Wpwd.getText().toString().equals("")){
                        JOptionPane.showMessageDialog(null,"密码不能为空","添加",
                                JOptionPane.WARNING_MESSAGE);
                    }else if(Wuserclass.getText().toString().equals("")){
                        JOptionPane.showMessageDialog(null,"用户类不能为空","添加",
                                JOptionPane.WARNING_MESSAGE);
                    }else {
                        o.tianjia(Wno.getText().toString(),Wpwd.getText().toString(),
                                Wuserclass.getText().toString());
                    }

                    }catch (Exception e1){
                    e1.printStackTrace();
                }JOptionPane.showMessageDialog
                        (null,"添加成功!","添加新用户",JOptionPane.INFORMATION_MESSAGE); }
        });
        Btnexit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Wno.setText("");
                Wpwd.setText("");
                Wuserclass.setText("");
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        UserAdd app = new UserAdd();
    }
}
