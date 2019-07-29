package Modle;

import util.Input;

import java.util.Scanner;


public class Stocker {

    public void stock(Shop shop) {
        //记录
        int count=0;

        System.out.println("欢迎您来进货");
        Scanner in = new Scanner(System.in);
        while(true) {
            System.out.println("请选择进的货物： 1.Watermelon (西瓜) 2.Mango (芒果)  3.exit");
            String str = in.next();
            if(str.equals("1") || str.equalsIgnoreCase("watermelon (西瓜)") || str.equalsIgnoreCase("1.watermelon(西瓜)")) {
                int a = Input.getInt("watermelon (西瓜)");
                shop.getFood()[0].addNum(a);
            }else if(str.equals("2") || str.equalsIgnoreCase("Mango (芒果)") || str.equalsIgnoreCase("2.Mango (芒果)")) {
                int a = Input.getInt("Mango (芒果)");
                shop.getFood()[1].addNum(a);
            }else if(str.equals("3") || str.equalsIgnoreCase("exit") || str.equalsIgnoreCase("3.exit")) {
                break;
            }else {
                System.err.println("这种食物我们么得！");
            }
        }
        //打印进货清单
        System.out.print("进货清单：");
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
        System.out.println("\n欢迎下次再来进货！");

    }
}
