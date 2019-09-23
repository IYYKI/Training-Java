package Day15_7_30_Tuesday.Fruit;

import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) throws Exception {
        Class c = Fruit.class;
        Constructor con = c.getDeclaredConstructor(int.class);
        con.setAccessible(true);
        Fruit fruit = (Fruit)con.newInstance(1);
        System.out.println(fruit.getNum());


        System.out.println();
        System.out.println("-----------======-----------");
        System.out.println();


        Class c1 = Class.forName("Day15_7_30_Tuesday.Fruit.Fruit");
        Constructor constructor = c1.getDeclaredConstructor(int.class);
        constructor.setAccessible(true);
        Fruit fruit1 = (Fruit)constructor.newInstance(2);
        System.out.println(fruit1.getNum());
    }
}