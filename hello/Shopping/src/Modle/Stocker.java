package Modle;

import util.Input;

import java.util.Scanner;


public class Stocker {

    public void stock(Shop shop) {
        //��¼
        int count=0;

        System.out.println("��ӭ��������");
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("��ѡ����Ļ�� 1.Watermelon (����) 2.Mango (â��)  3.exit");
            String str = in.next();
            if(str.equals("1") || str.equalsIgnoreCase("watermelon (����)") || str.equalsIgnoreCase("1.watermelon(����)")) {
                int a = Input.getInt("watermelon (����)");
                shop.getFood()[0].addNum(a);
            }else if(str.equals("2") || str.equalsIgnoreCase("Mango (â��)") || str.equalsIgnoreCase("2.Mango (â��)")) {
                int a = Input.getInt("Mango (â��)");
                shop.getFood()[1].addNum(a);
            }else if(str.equals("3") || str.equalsIgnoreCase("exit") || str.equalsIgnoreCase("3.exit")) {
                break;
            }else {
                System.err.println("����ʳ������ô�ã�");
            }
        }
        //��ӡ�����嵥
        System.out.print("�����嵥��");
        for(int i=0;i<shop.getFood().length;i++) {
            if(shop.getFood()[i].getNum() !=0) {
                System.out.print(shop.getFood()[i].getName() + ":" + shop.getFood()[i].getNum() + "  ");
            }else {
                count++;
            }
            if(count == shop.getFood().length) {
                System.err.print("None");
            }
        }
        System.out.println("\n��ӭ�´�����������");

    }
}
