package view;

import listener.MyListener;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class PlusView {
    private JFrame jframe; //窗口（设置可见、不可见）
    private JTextField jtf1; //编号值
    private JTextField jtf2; //姓名值
    private JComboBox jcb3; //性别选项
    private JComboBox jcb4; //部门选项
    private JTextField jtf5; //工资值
    private JComboBox jcb6; //查询条件选项
    private JPanel jp6; //查询面板（设置可见、不可见）
    private JButton btn1; //确认
    private JButton btn2; //取消
    private MainView mv;

    public PlusView(MainView mv) {
        this.mv = mv;
        jframe = new JFrame();
        Container con = jframe.getContentPane();
        con.setLayout(new GridLayout(7, 1));

        //第一行，编号和文本框
        JPanel jp1 = new JPanel();
        JLabel jl1 = new JLabel("编号:");
        jtf1 = new JTextField(10);
        jp1.add(jl1);
        jp1.add(jtf1);
        con.add(jp1);

        //第二行，姓名和文本框
        JPanel jp2 = new JPanel();
        JLabel jl2 = new JLabel("姓名:");
        jtf2 = new JTextField(10);
        jp2.add(jl2);
        jp2.add(jtf2);
        con.add(jp2);

        //第三行
        JPanel jp3 = new JPanel();
        JLabel jl3 = new JLabel("性别:");
        String[] sexItem = {"", "男", "女"};
        jcb3 = new JComboBox(sexItem);
        jp3.add(jl3);
        jp3.add(jcb3);
        con.add(jp3);


        //第四行
        JPanel jp4 = new JPanel();
        JLabel jl4 = new JLabel("部门:");
        String[] departmentItem = {"", "sale", "DigTheGraveOf", "TheMinistryOfGrave"};
        jcb4 = new JComboBox(departmentItem);
        jp4.add(jl4);
        jp4.add(jcb4);
        con.add(jp4);

        //第五行，工资和文本框
        JPanel jp5 = new JPanel();
        JLabel jl5 = new JLabel("工资:");
        jtf5 = new JTextField(10);
        jp5.add(jl5);
        jp5.add(jtf5);
        con.add(jp5);

        //第六行，查询条件
        jp6 = new JPanel();
        JLabel jl6 = new JLabel("请选择查询条件:");
        String[] selItem = {"", "and", "or"};
        jcb6 = new JComboBox(selItem);
        jp6.add(jl6);
        jp6.add(jcb6);
        jp6.setVisible(false);//查询条件面板最初不可见
        con.add(jp6);


        //第七行，确认和取消
        JPanel jp7 = new JPanel();
        btn1 = new JButton("确认");
        btn2 = new JButton("取消");
        jp7.add(btn1);
        jp7.add(btn2);
        con.add(jp7);

        MyListener ml = new MyListener(mv, this);
        btn1.addActionListener(ml);
        btn2.addActionListener(ml);

        jframe.setSize(220, 320);
        jframe.setLocation(700, 50);
        //窗口最初不可见
        jframe.setVisible(false);
    }


    public JFrame getJframe() {
        return jframe;
    }


    public void setJframe(JFrame jframe) {
        this.jframe = jframe;
    }


    public JTextField getJtf1() {
        return jtf1;
    }


    public void setJtf1(JTextField jtf1) {
        this.jtf1 = jtf1;
    }


    public JTextField getJtf2() {
        return jtf2;
    }


    public void setJtf2(JTextField jtf2) {
        this.jtf2 = jtf2;
    }


    public JComboBox getJcb3() {
        return jcb3;
    }


    public void setJcb3(JComboBox jcb3) {
        this.jcb3 = jcb3;
    }


    public JComboBox getJcb4() {
        return jcb4;
    }


    public void setJcb4(JComboBox jcb4) {
        this.jcb4 = jcb4;
    }


    public JTextField getJtf5() {
        return jtf5;
    }


    public void setJtf5(JTextField jtf5) {
        this.jtf5 = jtf5;
    }


    public JComboBox getJcb6() {
        return jcb6;
    }


    public void setJcb6(JComboBox jcb6) {
        this.jcb6 = jcb6;
    }


    public JPanel getJp6() {
        return jp6;
    }


    public void setJp6(JPanel jp6) {
        this.jp6 = jp6;
    }


    public JButton getBtn1() {
        return btn1;
    }


    public void setBtn1(JButton btn1) {
        this.btn1 = btn1;
    }


    public JButton getBtn2() {
        return btn2;
    }


    public void setBtn2(JButton btn2) {
        this.btn2 = btn2;
    }

}
