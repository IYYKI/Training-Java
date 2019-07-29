package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Eat {

    static Scanner in =new Scanner(System.in);

    public static int getInt(String str,int num) {
        while(true) {
            System.out.println("准备吃多少？ ：");
            try {
                int a = in.nextInt();
                if (a > num) {
                    System.out.println("不够了不够了喔，" + str + "只剩下" + num+ "这么多了");
                } else {
                    return a;
                }
            } catch (InputMismatchException e) {
                in.next();
                System.err.println("重新输入哟亲，格式有误哦");
            }
        }
    }


}
