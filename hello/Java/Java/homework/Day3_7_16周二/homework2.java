package Day3_7_16周二;

public class homework2 {
    public static void main(String[] args) {
        String b = " ";
        int a = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                a++;
                if (a == 10) {
                    b += i + "|";
                    System.out.println(b);
                    b = " ";
                    a = 0;
                } else {
                    b += "|" + i + " | ";
                }
            }
        }
        System.out.println(b);
    }
}
