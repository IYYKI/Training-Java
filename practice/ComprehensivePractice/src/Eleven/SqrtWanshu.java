package Eleven;

public class SqrtWanshu {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            double x = Math.sqrt(i + 100);
            double y = Math.sqrt(i + 268);
            if (x == (int) x && y == (int) y) {
                System.out.println("这个数是:" + i);

            }
        }
    }
}
