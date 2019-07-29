package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static Scanner in = new Scanner(System.in);
    public static int getInt(String str) {
        while(true) {
            System.out.println("请输入你要进的" + str + "的数量：");
            try {
                int a = in.nextInt();
                return a;
            } catch (InputMismatchException e) {
                in.next();
                System.err.println("输入格式有误，请重新输入！");
            }
        }
    }
}
