package Sixteen;

import java.util.Scanner;

/**
 * 16、一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同.
 */
public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int num = sc.nextInt();

        String str1 = num + "";
        // String str1 = Integer.toString(num);
        // String str1 = String.valueOf(num);

        StringBuilder str2 = new StringBuilder(str1);
        str2.reverse();
        int count = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                System.out.println(str1 + "不是回文数");
                break;
            } else {
                count++;
            }
        }
        if (count == str1.length()) {
            System.out.println(str1 + "是回文数");
        }
        Num("123123");
    }
    public static void Num(String str){
        if (!str.matches("\\d{5}")){
            System.out.println("请输入五位数字!");
        }else {
            if (str.charAt(0)==str.charAt(4)&&str.charAt(1)==str.charAt(3)){
                System.out.println(str+"是回文数!");
            }else {
                System.out.println(str+"不是回文数!");
            }
        }

    }
}
