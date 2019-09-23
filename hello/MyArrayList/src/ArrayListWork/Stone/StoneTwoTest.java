package ArrayListWork.Stone;

import java.util.Iterator;
import java.util.Stack;

public class StoneTwoTest {
    public static void main (String [] args){
        Stack stack = new Stack<>();
        stack.push(new Stone("StoneOne"));
        stack.push(new Stone("StoneTwo"));
        stack.push(new Stone("StoneThree"));

        Stone stone = (Stone)stack.pop();
        stack.pop();
        stack.push(stone);
        Iterator It = stack.iterator();
        while (It.hasNext()){
            Object obj = It.next();
            System.out.println(obj);
        }
    }
}

