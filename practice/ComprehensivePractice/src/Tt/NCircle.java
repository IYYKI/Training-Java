package Tt;
//22
import java.util.LinkedList;

public class NCircle {
    public static void main(String[] args) {
        pr22();
    }
    public static void pr22(){
        LinkedList ll = new LinkedList<>();
        for (int i = 1; i<=10;i++){
            ll.add(i);
        }
        while (ll.size()!=1){
            ll.addLast(ll.removeFirst());
            ll.addLast(ll.removeFirst());
            ll.removeFirst();
        }
        System.out.println(ll.get(0));
    }
}
