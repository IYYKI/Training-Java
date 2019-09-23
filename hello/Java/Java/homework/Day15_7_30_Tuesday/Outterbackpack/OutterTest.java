package Day15_7_30_Tuesday.Outterbackpack;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class OutterTest {
    public static void main(String[] args) throws Exception {
        /**Class outter = Class.forName("Day15_7_30_Tuesday.Outterbackpack.Outter");
         try {
         Field in = outter.getClass().getDeclaredField("in");
         in.setAccessible(true);
         //outter.in.test();
         } catch (NoSuchFieldException e) {
         e.printStackTrace();
         }
         }**/



        Class out = Outter.class;
        Object obj = out.newInstance();
        Field field = out.getDeclaredField("in");
        field.setAccessible(true);
        Object o = field.get(obj);

        Class in = o.getClass();
        Method m = in.getDeclaredMethod("test");
        m.setAccessible(true);
        m.invoke(o);
    }
}