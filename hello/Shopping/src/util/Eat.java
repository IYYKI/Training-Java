package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Eat {

    static Scanner in =new Scanner(System.in);

    public static int getInt(String str,int num) {
        while(true) {
            System.out.println("׼���Զ��٣� ��");
            try {
                int a = in.nextInt();
                if (a > num) {
                    System.out.println("�����˲�����ร�" + str + "ֻʣ��" + num+ "��ô����");
                } else {
                    return a;
                }
            } catch (InputMismatchException e) {
                in.next();
                System.err.println("��������Ӵ�ף���ʽ����Ŷ");
            }
        }
    }


}
