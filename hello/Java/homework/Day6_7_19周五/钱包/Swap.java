package Day6_7_19周五.钱包;

public class Swap {
    public static void exchange1(int i, int j){
        System.out.println(i+" "+j);

        int temp;
        temp= i;
        i = j;
        j = temp;
        //交换
        System.out.println("交换后1： "+i+" "+j);
    }
    public static void exchange(Purse p1, Purse q2){
        //交换Purse 的值
        System.out.println(p1+ " "+ q2);

        Purse temp = new Purse();
        temp = p1;
        p1 = q2;
        q2 = temp;
        //交换过后
        System.out.println("交换后2:"+p1+ " "+q2);
    }
    public static void exchange2(Purse p1,Purse p2){
        Purse pr = new Purse();
        int temp = pr.getMoney();
        int b1 = p1.getMoney();
        int b2 = p2.getMoney();
        System.out.println(p1+" "+p2);
        temp = b1;
        b1 = b2;
        b2 = temp;
        System.out.println("交换后3： "+p1+ " "+p2);

    }
}
