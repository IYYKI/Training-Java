package Run;
import Modle.*;

public class Test {

    public static void main(String[] args) {
        Food apple = new Watermelon();
        Food pear = new Mango();
        Food[] food = new Food[] {apple,pear};

        Food buyApple = new Watermelon();
        Food buyPear = new Mango();
        Food[] buyFood = new Food[] {buyApple,buyPear};


        Stocker stocker = new Stocker();
        Shop shop = new Shop(food,stocker);

        stocker.stock(shop);

        Father father = new Father("¸¸Ç×",buyFood);
        shop.buy(father);


        father.eat();

        Father son = new Son("¶ù×Ó",buyFood);
        son.eat();
    }

}
