package Day3_7_16周二;

public class homework3 {
    public static void main(String[] args) {
        int i = character('9');
        System.out.println(i);
    }

    public static int character(char ca) {
        int i = ca - '0';
        if (i >= 0 && i < 10) {
            return i;
        } else {
            return -1;
        }
    }
}
