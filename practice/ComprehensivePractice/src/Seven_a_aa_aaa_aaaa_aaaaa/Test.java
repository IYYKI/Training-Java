package Seven_a_aa_aaa_aaaa_aaaaa;

/**
 * 求s=a+aa+aaa+aaaa+aa...a的值，其中a是一个数字。例如2+22+222+2222+22222(此
 * 时共有5个数相加)，几个数相加有键盘控制.
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        java.util.Scanner inputNumb = new java.util.Scanner(System.in);
        String numble = inputNumb.next();
        System.out.println("请输入位数：");
        java.util.Scanner inputIndex = new java.util.Scanner(System.in);
        int index = inputIndex.nextInt();
        int sum = 0;
        String numble1 = "";
        for (int i = 1; i <= index; i++) {
            numble1 += numble;
            int shuzi = Integer.parseInt(numble1);
            System.out.println(shuzi);
            sum += shuzi;
        }
        System.out.println("总和为：" + sum);
    }
}
