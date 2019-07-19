package Day1_7_12周五.HomeWorkforday1;

import java.util.Scanner;

/**
 * 交换输出
 **/
public class HomeWork01 {
    public static void change() {
        Scanner in = new Scanner(System.in);
        System.out.println("输入第一个数: ");
        int a = in.nextInt();
        System.out.println("输入第二个数: ");
        int b = in.nextInt();
        System.out.println(b + "   " + a);
    }

    public static void main(String[] args) {
        change();
    }
}
