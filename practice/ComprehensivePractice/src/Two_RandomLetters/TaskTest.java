package Two_RandomLetters;

import java.util.*;
/**
 *
 * 随机产生20个不重复的小写字母并且排序
 *
 * **/
public class TaskTest {
    public static void main(String[] args) {
        s();

        /**List<Integer> cl = new LinkedList<>();
        for (int i = 0; i < 20; i++) {
            cl.add(i);
        }

        Random r = new Random();


        int sum = 20;
        char[] result = new char[sum];


        for (int i = 0; i < sum; i++) {
            int index = r.nextInt(cl.size());
            result[i] = (char) ((int) cl.get(index) + 97);

            cl.remove(index);
        }

        Arrays.sort(result);

        for (int i = 0; i < result.length; i++) {
            System.out.print(Arrays.toString(new char[]{result[i]}));
        }
    }**/


}
public static void s(){
    TreeSet st = new TreeSet<>();
    Random r = new Random();
    while (st.size()!=20){
        int a = r.nextInt(26);
        char c = (char)(a+97);
        st.add(c);
    }
    System.out.println(st);
}
}
