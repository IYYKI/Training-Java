package PersonInfo.MenuFrame;

import PersonInfo.AddAll.UserAdd;
import PersonInfo.AddAll.WorkerAdd;
import PersonInfo.DeleteAll.WorkerDelete;
import PersonInfo.Update_Select.UpdatePwdUserclass;
import PersonInfo.Update_Select.WorkerSelect;
import PersonInfo.Update_Select.WorkerUpdate;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MenuFrame extends JFrame {
    private JPanel panel = new JPanel();
    JMenuBar jmenubar1 = new JMenuBar();//创建菜单栏
    JMenu jmenu1 = new JMenu();
    JMenu jmenu2 = new JMenu();
    JMenu jmenu3 = new JMenu();
    JMenu jmenu4 = new JMenu();//创建菜单
    JMenuItem jmenuitem1 = new JMenuItem();
    JMenuItem jmenuitem2 = new JMenuItem();
    JMenuItem jmenuitem3 = new JMenuItem();
    JMenuItem jmenuitem4 = new JMenuItem();
    JMenuItem jmenuitem5 = new JMenuItem();
    JMenuItem jmenuitem6 = new JMenuItem();
    JMenuItem jmenuitem7 = new JMenuItem();//创建菜单条

    //定义方法
    public void go() {
        //设置窗口容器的布局管理器
        this.getContentPane().setLayout(new BorderLayout());
        //设置窗口的标题
        this.setTitle("人事管理系统");
        //添加菜单栏
        this.setJMenuBar(jmenubar1);
        //设置菜单和菜单项名称
        jmenu1.setText("用户管理");
        jmenuitem2.setText("修改密码和权限");
        jmenuitem4.setText("添加用户");
        jmenu2.setText("职工信息管理");
        jmenuitem1.setText("添加职工信息");
        jmenuitem3.setText("修改职工信息");
        jmenuitem5.setText("查询职工信息");
        jmenu3.setText("删除员工");
        jmenuitem6.setText("删除职工信息");
        jmenu4.setText("退出");
        jmenuitem7.setText("退出系统");
        //向菜单栏中添加菜单
        jmenubar1.add(jmenu1);
        jmenubar1.add(jmenu2);
        jmenubar1.add(jmenu3);
        jmenubar1.add(jmenu4);
        //向菜单中添加菜单项
        //jmenu1.add(jmenuitem1);
        jmenu1.add(jmenuitem2);
        jmenu1.add(jmenuitem4);
        jmenu2.add(jmenuitem1);
        jmenu2.add(jmenuitem3);
        jmenu2.add(jmenuitem5);
        jmenu3.add(jmenuitem6);
        jmenu4.add(jmenuitem7);
        jmenuitem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerAdd addusers1 = new WorkerAdd();
                panel.add(addusers1, "添加职工");
                CardLayout c1 = (CardLayout) panel.getLayout();

                c1.show(panel, "添加职工信息");
            }
        });
        jmenuitem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UpdatePwdUserclass o = new UpdatePwdUserclass();
                panel.add(o, "修改密码和权限");
                CardLayout c1 = (CardLayout) panel.getLayout();

                c1.show(panel, "修改密码和权限");
            }
        });
        jmenuitem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerUpdate o = new WorkerUpdate();
                panel.add(o, "修改职工信息");
                CardLayout c1 = (CardLayout) panel.getLayout();

                c1.show(panel, "修改职工信息");
            }
        });
        jmenuitem4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserAdd o = new UserAdd();
                panel.add(o, "");
                CardLayout c1 = (CardLayout) panel.getLayout();
                c1.show(panel, "添加用户");
            }
        });
        jmenuitem5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerSelect o = new WorkerSelect();
                panel.add(o, "查询职工");
                CardLayout c1 = (CardLayout) panel.getLayout();

                c1.show(panel, "查询职工信息");
            }
        });
        jmenuitem6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                WorkerDelete o = new WorkerDelete();
                panel.add(o, "删除职工");
                CardLayout c1 = (CardLayout) panel.getLayout();

                c1.show(panel, "删除职工信息");
            }
        });
        jmenuitem7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "欢迎下次光临！", "消息提示", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        //产生窗口的最佳尺寸、布局各组件，然后显示窗口
        pack();
        this.setSize(320, 240);
        setVisible(true);
    }

    public static void main(String[] args) {
        MenuFrame b = new MenuFrame();
        b.go();
    }
}