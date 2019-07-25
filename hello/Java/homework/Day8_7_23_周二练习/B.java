package Day8_7_23_周二练习;

public class B extends A {
    int b = 10;
    static {
        a++;
    }
    {
        b++;
    }
    public B(){
        a=a*b;
        System.out.println(a+" "+b);
    }
}
