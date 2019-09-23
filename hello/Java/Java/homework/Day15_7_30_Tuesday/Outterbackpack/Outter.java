package Day15_7_30_Tuesday.Outterbackpack;

import java.lang.reflect.Field;

public class Outter {

    private Inner in;

    public Outter() {
        in = new Inner();
    }

    private class Inner {
        public Inner() {
        }

        private void test() {
            System.out.println("test");
        }
    }
}
