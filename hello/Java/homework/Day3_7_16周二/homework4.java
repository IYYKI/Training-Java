package Day3_7_16周二;

class homework4 {
    public static void main(String[] args) {
        System.out.println("输入一个整数： ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        fun(n);
    }

    public static void fun(int n) {
        String a = "是质数";
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                a = "不是质数";
            }
        }
        System.out.println(a);
    }
}
