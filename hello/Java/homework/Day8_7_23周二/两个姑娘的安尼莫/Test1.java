package Day8_7_23周二.两个姑娘的安尼莫;

public class Test1 {
    public static void main (String [] args){
       Dog dog = new Dog("狗");
       Cat cat = new Cat("猫");
       TwoGirl GirlOne = new TwoGirl("我是GirlOne",dog);
        TwoGirl GirlTwo = new TwoGirl("我是GirlTwo",cat);
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
