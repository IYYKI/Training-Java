import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class Calculator extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    String []arr= {"7","8","9","+","4","5","6","-",
            "1","2","3","*",".","0","=","/"};
    JButton b[]=new JButton[16];
    JTextField jt;
    String input="";//输入的字符串
    public Calculator() {
        Container c=getContentPane();
        JPanel jp1=new JPanel();
        JPanel jp2=new JPanel();
        JPanel jp3=new JPanel();
        JButton b1=new JButton("清零");
        JButton b2=new JButton("退格");
        GridLayout g=new GridLayout(4,4,5,5);
        jp1.setLayout(new BorderLayout());
        jp2.setLayout(g);

        jp3.setLayout(new GridLayout(1, 2,5,5));

        jt=new JTextField();
        jt.setPreferredSize(new Dimension(150,30));
        jt.setHorizontalAlignment(SwingConstants.LEFT);
        c.add(jp1,BorderLayout.NORTH);
        jp1.add(jt,BorderLayout.WEST);
        jp1.add(jp3,BorderLayout.EAST);
        jp3.add(b1);
        jp3.add(b2);
        b1.setBackground(Color.gray);
        b2.setBackground(Color.gray);
        b1.addActionListener(this);
        b2.addActionListener(this);
        for(int i=0;i<arr.length;i++) {
            b[i]=new JButton(arr[i]);
            jp2.add(b[i]);
            b[i].addActionListener(this);
        }

        c.add(jp2,BorderLayout.CENTER);
        setVisible(true);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 250);
        setTitle("计算器");


    }
    @Override
    public void actionPerformed(ActionEvent e) {

        // TODO Auto-generated method stub
        int t=0;
        String s=e.getActionCommand();
        if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) {
            input+=" "+s+" ";      //如果碰到运算符，就在运算符前后分别加一个空格，
            //为后面的分解字符串做准备

        }else if(s.equals("清零")) {
            input="";
        }else if(s.equals("退格")) {
            if((input.charAt(input.length()-1))==' ') { //检测字符串的最后一个字符是否为空格,
                input=input.substring(0,input.length()-3);//如果是则删除末尾3个字符，否则删除
                //1个字符
            }else {
                input=input.substring(0,input.length()-1);
            }
        }
        else if(s.equals("=")) {
            input=compute(input);
            jt.setText(input);
            input="";
            t=1;
        }
        else
            input += s;
        if(t==0) {
            jt.setText(input);
        }
    }
    private String compute(String str) {
        // TODO Auto-generated method stub
        String array[];
        array=str.split(" ");
        Stack<Double> s=new Stack<Double>();
        Double a=Double.parseDouble(array[0]);
        s.push(a);
        for(int i=1;i<array.length;i++) {
            if(i%2==1) {
                if(array[i].compareTo("+")==0)
                {
                    double b= Double.parseDouble(array[i+1]);
                    s.push(b);
                }
                if(array[i].compareTo("-")==0)
                {
                    double b= Double.parseDouble(array[i+1]);
                    s.push(-b);
                }
                if(array[i].compareTo("*")==0)
                {
                    double b= Double.parseDouble(array[i+1]);

                    double c=s.pop();

                    c*=b;
                    s.push(c);


                }
                if(array[i].compareTo("/")==0)
                {
                    double b= Double.parseDouble(array[i+1]);

                    double c=s.peek();
                    s.pop();
                    c/=b;
                    s.push(c);


                }
            }
        }
        double sum=0;
        while(!s.isEmpty()) {
            sum+=s.pop();

        }
        String result=String.valueOf(sum);
        return result;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Calculator();
    }



}