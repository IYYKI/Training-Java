package Four_PrimeFactors;

import java.util.Scanner;

/**
 * 4、将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
 * 程序分析：对n进行分解质因数，应先找到一个最小的质数k，然后按下述步骤完成:
 * (1)如果这个质数恰等于n，则说明分解质因数的过程已经结束，打印出即可。
 * (2)如果n >= k，但n能被k整除，则应打印出k的值，并用n除以k的商,作为新的正整数n,重复执行第一步.
 * (3)如果n不能被k整除，则用k+1作为k的值,重复执行第一步。
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个正整数:");
        int n = sc.nextInt();
        int k = 2;
        System.out.print(n + "=");//输出第一步格式
        while (n >= k) {//初值k为2,n为输入的数字,在程序执行的过程中k渐渐变大(k++),n渐渐变小(n/k)
            if (n == k) {//当n和k相等的时候,就直接输出n的值(此时输出k也行,因为n==k)
                System.out.println(n);
                break;
            } else if (n % k == 0) {
                System.out.print(k + "*");//如果n <> k，但n能被k整除，则应打印出k的值
                n /= k;//n除以k的商,作为新的正整数你n
            } else {
                k++;//如果n不能被k整除，则用k+1作为k的值
            }
        }
    }
}
