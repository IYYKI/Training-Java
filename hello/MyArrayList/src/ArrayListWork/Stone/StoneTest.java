package ArrayListWork.Stone;

import java.util.HashSet;
import java.util.Iterator;

public class StoneTest {
    public static void main (String [] args){
        HashSet hash = new HashSet<>();
        hash.add(new Stone("StoneOne"));
        hash.add(new Stone("StoneTwo"));
        hash.add(new Stone("StoneThree"));
        hash.add(new Stone("StoneFour"));

        Iterator it = hash.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
        }
    }
}