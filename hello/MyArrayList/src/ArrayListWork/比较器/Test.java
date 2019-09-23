package ArrayListWork.比较器;



import java.util.Collections;
import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {
        Person p = new Person("a",0,11);
        Person p1 = new Person("b",1,22);
        Person p2 = new Person("c",2,33);
        Person p3 = new Person("d",3,44);
        Person p4 = new Person("e",4,55);

        LinkedList ll = new LinkedList<>();
        ll.add(p);
        ll.add(p1);
        ll.add(p2);
        ll.add(p3);
        ll.add(p4);
        System.out.println("原列表");
        System.out.println(ll);

        System.out.println("------------===/===/==------------");

        System.out.println("升序，id");
        Comparators c1 = new Comparators("升序","id");
        Collections.sort(ll, c1);
        System.out.println(ll);

        System.out.println("------------===/===/==------------");

        System.out.println("降序，id");
        Comparators c2 = new Comparators("降序","id");
        Collections.sort(ll, c2);
        System.out.println(ll);

        System.out.println("------------===/===/==------------");

        System.out.println("升序，number");
        Comparators c3 = new Comparators("升序","number");
        Collections.sort(ll, c3);
        System.out.println(ll);

        System.out.println("------------===/===/==------------");

        System.out.println("降序，number");
        Comparators c4 = new Comparators("降序","number");
        Collections.sort(ll, c4);
        System.out.println(ll);

        System.out.println();

        System.out.println("升序，name");
        Comparators c5 = new Comparators("升序","name");
        Collections.sort(ll, c5);
        System.out.println(ll);

        System.out.println("------------===/===/==------------");

        System.out.println("降序，name");
        Comparators c6 = new Comparators("降序","name");
        Collections.sort(ll, c6);
        System.out.println(ll);

    }

}