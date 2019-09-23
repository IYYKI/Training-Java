package Day1_7_12周五.HomeWorkforday1;

import java.util.Scanner;

/**
 * 浮点数据，保留两位
 **/
public class HomeWork05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入");
        double d = s.nextDouble();
        System.out.println(String.format("%.2f", d));
    }
}
