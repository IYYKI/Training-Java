package Day2_7_15周一;

public class Homework6 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {//1-10
            for (int j = 1; j <= i; j++) {//1=1
                System.out.print(i + "*" + j + "=" + i * j + " ");
                if (i == j) {
                    System.out.println();
                }
            }
        }
    }
}