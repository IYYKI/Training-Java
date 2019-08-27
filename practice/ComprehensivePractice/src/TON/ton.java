package TON;

import java.util.LinkedList;

public class ton {
    public static void main(String[] args) {
    pr21(3);
    }
    public static void pr21(int m){
        //Á´±í
        LinkedList ll = new LinkedList<>();
        for (int i = 1; i<=10; i++){
            ll.add(i);
        }
        for (int i = 1; i<= m ; i++){
            ll.addFirst(ll.removeLast());
        }
        System.out.println(ll);
    }
}
