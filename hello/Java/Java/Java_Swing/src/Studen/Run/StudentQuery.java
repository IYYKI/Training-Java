package Studen.Run;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class StudentQuery {
     private JTextField jtf1;
     private JTextField jtf2;
     private JTextField jtf3;
     private JTextField jtf4;
     private JButton btn1;
     private JButton btn2;

    public StudentQuery() {
        JFrame jf = new JFrame("边界布局");
        Container con = jf.getContentPane();
        con.setLayout(new GridLayout(5, 2));
        //1-1学号
        JLabel lab1 = new JLabel("学号");
        lab1.setForeground(Color.GRAY);
        lab1.setFont(new Font("微软雅黑",1,40));
        con.add(lab1);
        //1-2
        jtf1 = new JTextField(20);
        jtf1.setFont(new Font("微软雅黑",1,40));
        con.add(jtf1);

        //2-1姓名
        JLabel lab2 = new JLabel("姓名");
        lab2.setForeground(Color.GRAY);
        lab2.setFont(new Font("微软雅黑",1,40));
        con.add(lab2);

        //2-2
        jtf2 = new JTextField(20);
        jtf2.setBackground(Color.lightGray);
        jtf2.setFont(new Font("微软雅黑",1,40));
        jtf2.setEnabled(false);
        con.add(jtf2);

        //3-1班级
        JLabel lab3 = new JLabel("班级");
        lab3.setForeground(Color.GRAY);
        lab3.setFont(new Font("微软雅黑",1,40));
        con.add(lab3);
        //3-2
        jtf3 = new JTextField(20);
        jtf3.setBackground(Color.lightGray);
        jtf3.setFont(new Font("微软雅黑",1,40));
        jtf3.setEnabled(false);
        con.add(jtf3);

        //4-1成績
        JLabel lab4 = new JLabel("成績");
        lab4.setForeground(Color.GRAY);
        lab4.setFont(new Font("微软雅黑",1,40));
        con.add(lab4);
        //4-2
        jtf4 = new JTextField(20);
        jtf4.setBackground(Color.lightGray);
        jtf4.setFont(new Font("微软雅黑",1,40));
        jtf4.setEnabled(false);
        con.add(jtf4);

        //5-1查詢
        btn1 = new JButton("查询");
        con.add(btn1);

        //5-2清空
        btn2 = new JButton("清空");
        con.add(btn2);

        Studen.Run.MyListener ml=new Studen.Run.MyListener(this);
        btn1.addActionListener(ml);
        btn2.addActionListener(ml);

        jf.setVisible(true);
        jf.setSize(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JTextField getJtf1() {
        return jtf1;
    }

    public void setJtf1(JTextField jtf1) {
        this.jtf1 = jtf1;
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

    public JTextField getJtf2() {
        return jtf2;
    }

    public void setJtf2(JTextField jtf2) {
        this.jtf2 = jtf2;
    }

    public JTextField getJtf3() {
        return jtf3;
    }

    public void setJtf3(JTextField jtf3) {
        this.jtf3 = jtf3;
    }

    public JTextField getJtf4() {
        return jtf4;
    }

    public void setJtf4(JTextField jtf4) {
        this.jtf4 = jtf4;
    }





}

