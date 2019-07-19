package Day2_7_15周一;

import java.util.*;

public class Homework1 {
    public static void main(String[] args) {
        int money = 100;
        int  x = 0;//    定义3个整数类型的数
        int  y = 0;//
        int  i = 0;//
        String str;
        Scanner s = new Scanner(System.in);
        System.out.println("您的余额为100元 ");
        System.out.print("输入金额 ");
        x = s.nextInt();
        System.out.print("存或取||+ -");
        str = s.next();

        switch (str) {
            case "+": {
                System.out.println(money);
                break;
            }
            case "-": {
                i = x - y;
                break;
            }
        }
        System.out.println(i);
        System.out.println("完事儿了，还要搞？你程序再运行一遍！");
        s.nextLine();
    }
}
