package Modle;

import java.util.Scanner;
import util.Count;
import util.Eat;

public class Father {
    private Food[] food;
    private String name;


    public Father(String name,Food[] food) {
        this.name = name;
        this.food = food;
    }

    public void setFood(Food[] food) {
        this.food = food;
    }

    public Food[] getFood() {
        return food;
    }

    public void eat() {
        //
        int count = 0;

        Scanner in = new Scanner(System.in);
        System.out.print("\n"+ name + "������: ");
        Count.countPrint(food, count);

        while (true) {
            count=0;
            System.out.print("\n���ϸ�â�����ĸ��� ");
            Count.countPrint(food, count);

            System.out.println("�����������룺Donteat");
            String str = in.next();
            if(str.equalsIgnoreCase("watermelon")) {
                int a = Eat.getInt("watermelon", food[0].getNum());
                food[0].reduceNum(a);
            }else if(str.equalsIgnoreCase("Mango")) {
                int a = Eat.getInt("Mango", food[1].getNum());
                food[1].reduceNum(a);
            }else if(str.equalsIgnoreCase("Donteat")) {
                break;
            }else {
                System.err.println("ô�а�");
            }
        }
        System.out.println("�Ժ���");

    }
}
