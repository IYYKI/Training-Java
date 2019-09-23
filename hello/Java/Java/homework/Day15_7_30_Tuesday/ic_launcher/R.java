package Day15_7_30_Tuesday.ic_launcher;

import java.lang.reflect.Field;

public final class R {
    public static final class Drawable {
        public static final int ic_launcher=100;
    }
    public static void Get()throws Exception{
        Class c = Drawable.class;
        Field field = c.getField("ic_launcher");
        System.out.println(field.get(c));
    }
}
