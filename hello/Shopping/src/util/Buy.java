package util;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Buy {
    static Scanner in = new Scanner(System.in);
    public static int getInt(String str,int num) {
        while(true) {
            System.out.println("请输入你准备购买" + str + "的数量：");
            try {
                int a = in.nextInt();
                if(a>num) {
                    System.err.println("没那么多咯" + str + "还剩下" + num);
                }else {
                    return a;
                }

            } catch (InputMismatchException e) {
                in.next();
                System.err.println("输入的格式不对哦，再输一遍吧");
            }
        }
    }
}
