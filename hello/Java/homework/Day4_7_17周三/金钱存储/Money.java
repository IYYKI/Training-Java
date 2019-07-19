package Day4_7_17周三.金钱存储;

import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        int money = 100;//底金
        int qian = 100;//判断数
        int x = 0;   //存或取的金额
        String str;
        Scanner s = new Scanner(System.in);
        System.out.println("您的余额为100元 ");
        System.out.print("输入金额 ");
        x = s.nextInt();
        System.out.print("存或取 (+/-)  ");
        str = s.next();

        switch (str) {
            case "+": {
                System.out.println(money + x);
                if (money + x >= qian) {
                    System.out.println("存款成功");
                }
                break;
            }
            case "-": {
                System.out.println(money - x);
                if (money - x <= qian) {
                    System.out.println("没钱了!!，要不把银行抢了？!");
                }
            }
        }
    }
}