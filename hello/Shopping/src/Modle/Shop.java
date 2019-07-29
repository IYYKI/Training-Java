package Modle;

import util.Buy;

import java.util.Scanner;


public class Shop {
    private Food[] food;
    private Stocker stocker;

    public Shop(Food[] food, Stocker stocker) {
        super();
        this.food = food;
        this.stocker = stocker;
    }

    public void buy(Father father) {
        //����
        int count = 0;

        System.out.println("���ã���ӭ����");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("��ѡ����Ҫ�������Ʒ,����Щ��");
            for (int i = 0; i < food.length; i++) {
                System.out.print((i + 1) + "." + food[i].getName() + ":" + food[i].getNum() + "  ");
            }
            System.out.println("�˳������룺3.exit");
            String str = in.next();

            if (str.equals("1") || str.equalsIgnoreCase
                    ("watermelon (����)") || str.equalsIgnoreCase("1.watermelon (����)")) {
                if (food[0].getNum() == 0) {
                    System.err.println("������!�ٿ�����");
                } else {
                    int a = Buy.getInt("watermelon (����)", food[0].getNum());
                    food[0].reduceNum(a);
                    father.getFood()[0].addNum(a);
                }
            } else if (str.equals("2") || str.equalsIgnoreCase
                    ("mango (â��)") || str.equalsIgnoreCase("2.mango (â��)")) {
                if (food[1].getNum() == 0) {
                    System.err.println("������!�ٿ�����");
                } else {
                    int a = Buy.getInt("mango(â��)", food[1].getNum());
                    food[1].reduceNum(a);
                    father.getFood()[1].addNum(a);
                }

            } else if (str.equals("3") || str.equalsIgnoreCase("exit") || str.equalsIgnoreCase("3.exit")) {
                break;
            } else {
                System.err.println("����û�����л���Ŷ���ٿ�����");
            }
        }
        //��ӡ�����嵥
        System.out.print("�����嵥��");
        for (int i = 0; i < father.getFood().length; i++) {
            if (father.getFood()[i].getNum() != 0) {
                System.out.print(father.getFood()[i].getName() + ":" + father.getFood()[i].getNum() + " ");
            } else {
                count++;
            }
            if (count == father.getFood().length) {
                System.err.print("None");
            }
        }
        System.out.print("\n��ӭ�´ι��٣�");
    }

    public Food[] getFood() {
        return food;
    }

    public void setFood(Food[] food) {
        this.food = food;
    }

    public Stocker getStocker() {
        return stocker;
    }

    public void setStocker(Stocker stocker) {
        this.stocker = stocker;
    }


}
