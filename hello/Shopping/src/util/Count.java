package util;

import Modle.Food;

public class Count {

    public static void countPrint(Food[] food, int count) {
        for (int i = 0; i < food.length; i++) {
            if (food[i].getNum() != 0) {
                System.out.print(food[i].getName() + ":" + food[i].getNum() + "  ");
            } else {
                count++;
            }
            if (count == food.length) {
                System.err.println("ц╩спак");
                return;
            }
        }
    }
}
