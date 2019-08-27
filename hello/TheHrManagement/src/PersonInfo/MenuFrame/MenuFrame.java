package PersonInfo.MenuFrame;

import PersonInfo.AddAll.WokerAdd;
import PersonInfo.Update_Select.UpdatePwdUserClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    private JPanel panel = new JPanel();
    JMenuBar jmenubar1 = new JMenuBar();//创建菜单栏
    JMenu jMenu1 = new JMenu();
    JMenu jMenu2 = new JMenu();
    JMenu jMenu3 = new JMenu();
    JMenu jMenu4 = new JMenu();
    JMenuItem jMenuItem1 = new JMenuItem();
    JMenuItem jMenuItem2 = new JMenuItem();
    JMenuItem jMenuItem3 = new JMenuItem();
    JMenuItem jMenuItem4 = new JMenuItem();
    JMenuItem jMenuItem5 = new JMenuItem();
    JMenuItem jMenuItem6 = new JMenuItem();
    JMenuItem jMenuItem7 = new JMenuItem();//创建菜单栏
    //定义方法
    public void go(){
        //设置窗口容器的布局管理器
        this.getContentPane().setLayout(new BorderLayout());
        //设置窗口的标题
        this.setTitle("人事管理系统");
        //添加菜单栏
        this.setJMenuBar(jmenubar1);
        //设置菜单和菜单项目名
        jMenu1.setText("用户管理");
        jMenuItem2.setText("修改密码和权限");
        jMenuItem4.setText("添加用户");
        jMenu2.setText("职工信息管理");
        jMenuItem1.setText("添加管理信息");
        jMenuItem3.setText("修改职工信息");
        jMenuItem5.setText("查询职工信息");
        jMenu3.setText("删除员工");
        jMenuItem6.setText("删除职工信息");
        jMenu4.setText("退出");
        jMenuItem7.setText("退出系统");
        //向菜单栏中添加菜单
        jmenubar1.add(jMenu1);
        jmenubar1.add(jMenu2);
        jmenubar1.add(jMenu3);
        jmenubar1.add(jMenu4);
        //向菜单中添加菜单项
        jMenu1.add(jMenuItem2);
        jMenu1.add(jMenuItem4);
        jMenu2.add(jMenuItem1);
        jMenu2.add(jMenuItem3);
        jMenu2.add(jMenuItem5);
        jMenu2.add(jMenuItem6);
        jMenu2.add(jMenuItem7);
        jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WokerAdd addusers1 = new WokerAdd();
                panel.add(addusers1,"添加职工");
                CardLayout c1 = (CardLayout)panel.getLayout();
                c1.show(panel,"添加职工信息");
            }
        });
        jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePwdUserClass o  = new UpdatePwdUserClass();
                panel.add(o,"修改密码和权限");
                CardLayout c1 = (CardLayout)panel.getLayout();
                c1.show(panel,"修改密码和权限");
            }
        });
        jMenuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePwdUserClass o  = new UpdatePwdUserClass();
                panel.add(o,"修改职工信息");
                CardLayout c1 = (CardLayout)panel.getLayout();
                c1.show(panel,"修改职工信息");
            }
        });
        jMenuItem4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePwdUserClass o  = new UpdatePwdUserClass();
                panel.add(o,"");
                CardLayout c1 = (CardLayout)panel.getLayout();
                c1.show(panel,"添加用户");
            }
        });
        jMenuItem5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePwdUserClass o  = new UpdatePwdUserClass();
                panel.add(o,"查询职工");
                CardLayout c1 = (CardLayout)panel.getLayout();
                c1.show(panel,"查询职工信息");
            }
        });
        jMenuItem6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdatePwdUserClass o  = new UpdatePwdUserClass();
                panel.add(o,"删除职工");
                CardLayout c1 = (CardLayout)panel.getLayout();
                c1.show(panel,"删除职工信息");
            }
        });
        jMenuItem7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(null,"欢迎下次光临！",
                       "消息提示",JOptionPane.INFORMATION_MESSAGE);
               System.exit(0);
            }
        });
        //产生窗口、布局各组件，然后显示窗口
        pack();
        this.setSize(320,240);
        setVisible(true);
    }

    public static void main(String[] args) {
        MenuFrame b = new MenuFrame();
        b.go();
    }
}
