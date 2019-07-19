package Day1_7_12周五.HomeWorkforday1;

import java.util.Scanner;

public class HomeWork02 {
    public static void main(String[] args) {
        System.out.println("请输入半径：");
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        double s = 0, L = 0, zj;
        s = r * r * 3.14;//面积
        L = 3.14 * r * 2;//周长
        zj = Math.PI * 2;

        System.out.println("该圆的面积为：" + s);
        System.out.println("该圆的周长为：" + L);
        System.out.println("该圆的直径为:" + zj);


    }
}
