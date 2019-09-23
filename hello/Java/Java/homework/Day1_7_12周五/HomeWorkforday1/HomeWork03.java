package Day1_7_12周五.HomeWorkforday1;

import java.util.Scanner;

/**
 * 判断输入数的奇偶
 **/
public class HomeWork03 {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);

        System.out.println("输入一个整数");

        int a = scan.nextByte();

        if (a % 2 != 0)

            System.out.printf("%d是奇数", a);

        else

            System.out.printf("%d是偶数", a);

    }

}

