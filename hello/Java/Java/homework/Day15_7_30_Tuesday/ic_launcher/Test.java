package Day15_7_30_Tuesday.ic_launcher;


import java.lang.reflect.Method;

public class Test {
    public static void main (String [] args)throws Exception{
        Class get = Class.forName("Day15_7_30_Tuesday.ic_launcher.R");
        Method me = get.getDeclaredMethod("Get");
        me.invoke(get.newInstance());
    }
}
