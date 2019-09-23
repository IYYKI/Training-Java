package Day1_7_12周五.HomeWorkforday1;

import java.util.Scanner;

/**
 * 输入一个数，如果能被2和3整除
 * 则输出：输入+"能被N整除
 **/
public class HomeWork07 {
    public static void main(String[] args) {

    int num = new Scanner(System.in).nextInt();
  if ((num % 3 == 0) && (num % 2 == 0)) {
        System.out.println(  num +"可以");
    } else {
        System.out.println(num+"不行");
    }
}

}
