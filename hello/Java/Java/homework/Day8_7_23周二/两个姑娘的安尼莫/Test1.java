package Day8_7_23周二.两个姑娘的安尼莫;

import homework.Day8_7_23周二.两个姑娘的安尼莫.Cat;
import homework.Day8_7_23周二.两个姑娘的安尼莫.Dog;

public class Test1 {
    public static void main (String [] args){
       Dog dog = new Dog("狗");
       Cat cat = new Cat("猫");
       Day8_7_23周二.两个姑娘的安尼莫.TwoGirl GirlOne = new Day8_7_23周二.两个姑娘的安尼莫.TwoGirl("我是GirlOne",dog);
        Day8_7_23周二.两个姑娘的安尼莫.TwoGirl GirlTwo = new Day8_7_23周二.两个姑娘的安尼莫.TwoGirl("我是GirlTwo",cat);
        /**
         * 狗叫
         * */
        System.out.println(GirlOne.getName()+"有只"+GirlOne.getAnimal().getName());
        GirlOne.getAnimal().Shouting();
        /*************************************************************************/
        System.out.println(GirlTwo.getName()+"有只"+GirlOne.getAnimal().getName());
        /**
         * 猫叫
         * */
        GirlTwo.getAnimal().Shouting();
    }
}
