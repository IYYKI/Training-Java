package Day8_7_23_周二练习;

public class A {
    int b = 10;
    {
        a++;
        b++;
    }
    static {
        a=15;
    }
    static int a = 10;
    public A(){
        a*=5;
        b*=5;
        System.out.println(a+" "+b);
    }
}
