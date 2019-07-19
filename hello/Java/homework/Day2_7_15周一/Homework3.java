package Day2_7_15周一;

import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 101);              //随机生成100以内的数
        Scanner sc = new Scanner(System.in);               //用户输入
        //int num=(int)(Math.random()*101);
        System.out.println("猜猜数字是几？");              //输出拦提示
        while (true) {                                  //死循环，直到猜对中断循环
            System.out.println("猜！：");               //输出拦提示
            int number = sc.nextInt();                //正数类型
            if (number > num) {                      //获取键盘输入的数进行判断 ，此处是输入的大于生成的随机数
                System.out.println("菜鸡猜大了");    //输出拦提示

            } else if (number < num) {            //获取键盘输入的
                System.out.println("菜鸡猜小了");

            } else {
                System.out.println("牛逼猜对了");
                System.out.println("没错这个数是" + num);
                break;
            }
        }
    }
}