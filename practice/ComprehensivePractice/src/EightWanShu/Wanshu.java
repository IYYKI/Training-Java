package EightWanShu;

public class Wanshu {
    private static int count;

    public static void main(String[] args) {
        count=0;
        //循环判断输出1~1000之间所有的完数
        System.out.println("以下为1000以内的完数：");
        for(int i = 2; i <= 1000; i++)
        {
            checkIs(i);
        }
        System.out.println();
        System.out.println("1000以内的完数一共有" + count + "个。");
    }
    //完数方法
    //判断是否为完数
    public static void checkIs(int i)
    {
        int sum = 0;
        //用1~i-1去整除i，如果能被整除，则j即为i的因子，加到sum中去。
        for(int j = 1; j < i; j++) {
            if(i % j == 0) {
                sum += j;
            }
        }
        //计数
        //如果i所有因子相加后的sum和i本身的值相同，则i为完数，并计数加一。
        if(sum == i)
        {
            count++;
            System.out.print(i + "\t");
        }
    }
}
