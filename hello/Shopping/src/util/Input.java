package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    static Scanner in = new Scanner(System.in);
    public static int getInt(String str) {
        while(true) {
            System.out.println("��������Ҫ����" + str + "��������");
            try {
                int a = in.nextInt();
                return a;
            } catch (InputMismatchException e) {
                in.next();
                System.err.println("�����ʽ�������������룡");
            }
        }
    }
}
