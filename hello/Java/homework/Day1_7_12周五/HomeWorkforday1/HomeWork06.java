package Day1_7_12周五.HomeWorkforday1;

import java.util.Scanner;

/**
 * 输入的数+N、N2、N3整除
 **/
public class HomeWork06 {
    public static void main(String[] args) {
        Nb();
    }

    private static void Nb() {
        int N = 3;
        int N2 = 4;
        int N3 = 5;
        Scanner in = new Scanner(System.in);
        System.out.println("请输入你要的数");
        int i = in.nextInt();
        if ((N % 3 == 0) || (N2 % 4 == 0) || (N3 % 5 == 0)) {
            System.out.println(i + "可以被" + N + "或者" + N2 + "或者" + N3 + "整除");
        } else {
            System.out.println(i + "不可以被" + N + "或者" + N2 + "或者" + N3 + "整除");
        }
    }
}
