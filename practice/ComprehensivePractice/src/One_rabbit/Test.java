package One_rabbit;
/**
 * 古典问题：有一对兔子，
 * 从出生后第3个月起每个月都生一对兔子，
 * 小兔子长到第三个月后每个月又生一对兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少
 **/

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入第几个月:");
        int month = sc.nextInt();
        System.out.println("第" + month + "个月，兔子的总数为:" + rabbit(month));
    }

    private static int rabbit(int month) {
        if ((1 == month) || (2 == month))
            return 1;
        else
            return (rabbit(month - 1) + rabbit(month - 2));

    }
}
