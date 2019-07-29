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
        //计数
        int count = 0;

        System.out.println("您好，欢迎光临");
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("请选择需要购买的商品,有这些：");
            for (int i = 0; i < food.length; i++) {
                System.out.print((i + 1) + "." + food[i].getName() + ":" + food[i].getNum() + "  ");
            }
            System.out.println("退出请输入：3.exit");
            String str = in.next();

            if (str.equals("1") || str.equalsIgnoreCase
                    ("watermelon (西瓜)") || str.equalsIgnoreCase("1.watermelon (西瓜)")) {
                if (food[0].getNum() == 0) {
                    System.err.println("卖完啦!再看看吧");
                } else {
                    int a = Buy.getInt("watermelon (西瓜)", food[0].getNum());
                    food[0].reduceNum(a);
                    father.getFood()[0].addNum(a);
                }
            } else if (str.equals("2") || str.equalsIgnoreCase
                    ("mango (芒果)") || str.equalsIgnoreCase("2.mango (芒果)")) {
                if (food[1].getNum() == 0) {
                    System.err.println("卖完啦!再看看吧");
                } else {
                    int a = Buy.getInt("mango(芒果)", food[1].getNum());
                    food[1].reduceNum(a);
                    father.getFood()[1].addNum(a);
                }

            } else if (str.equals("3") || str.equalsIgnoreCase("exit") || str.equalsIgnoreCase("3.exit")) {
                break;
            } else {
                System.err.println("我们没有这中货物哦，再看看吧");
            }
        }
        //打印购物清单
        System.out.print("购物清单：");
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
        System.out.print("\n欢迎下次光临！");
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
