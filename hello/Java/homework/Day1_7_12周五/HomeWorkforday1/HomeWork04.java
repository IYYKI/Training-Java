package Day1_7_12周五.HomeWorkforday1;
/**
 * 拆数字
 ***/

import java.util.Scanner;

public class HomeWork04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//键盘输入数字
        System.out.println("请输入一个数");
        int a = sc.nextInt();
        String str = String.valueOf(a); //将数字转换成字符串
        int b = str.length(); //判断该字符串长度，即数字位数
        int a1 = a / 10000;
        int a2 = a / 1000 % 10;
        int a3 = a % 1000 / 100;
        int a4 = a % 100 / 10;
        int a5 = a % 10;
        if (b <= 5) {
            System.out.println(a1 + "*" + a2 + "*" + a3 + "*" + a4 + "*" + a5 + "*");
            System.out.println("该数字：" + b + "位，");
        } else {
            System.out.println("请输入正确的数字长度！");
        }
    }
}
/**while (b > 0) {
 int x = a % temp; //得到末尾数数字
 a = a / temp;
 System.out.print(x + "*");
 b--;
 }**/