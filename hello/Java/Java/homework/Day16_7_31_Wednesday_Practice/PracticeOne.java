package Day16_7_31_Wednesday_Practice;

import java.util.ArrayList;

public class PracticeOne {
    public static void main (String [] args){
        ArrayList a = new ArrayList<>();
        a.add(1);
        a.add("abc");
        a.add('z');
        a.add(2,"fuck!");
        a.add(0,true);
        a.add(5,false);
        System.out.println(a.size());
        System.out.println(a);
    }
}
