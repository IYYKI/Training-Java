package Day15_7_30_Tuesday.child;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ChildTest {
    public static void main (String [] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
      Class c1 = Class.forName("Day15_7_30_Tuesday.child.Child");
      System.out.println(c1);
      Constructor constructor = c1.getDeclaredConstructor();
      Child child = (Child)constructor.newInstance();
      Method method = c1.getDeclaredMethod("eat", String.class);
      method.invoke(child,"大头儿子: ");
    }
}
