package util;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Buy {
    static Scanner in = new Scanner(System.in);
    public static int getInt(String str,int num) {
        while(true) {
            System.out.println("��������׼������" + str + "��������");
            try {
                int a = in.nextInt();
                if(a>num) {
                    System.err.println("û��ô�࿩" + str + "��ʣ��" + num);
                }else {
                    return a;
                }

            } catch (InputMismatchException e) {
                in.next();
                System.err.println("����ĸ�ʽ����Ŷ������һ���");
            }
        }
    }
}
