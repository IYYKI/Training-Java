package NineTeen;

import java.util.Scanner;

public class San {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一共多少行");
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][0] = 1;
                arr[i][i] = 1;

            }
        }
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }

        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
/**
 * public static void pr19(int row){
 * //定义一个二维数组 可以存放row个一维数组
 * int arr [][] = new int[row][];
 * for (int i = 0; i<arr.length; i++){
 * //给一维数组初始化，长度为 i+1；
 * arr[i] = new int[i+1];
 * //赋值
 * //给数组首位都赋值为1；
 * arr[i][0] = 1;
 * arr[i][i]=1;
 * //中间部分赋值
 * for (int j = 1; j<i; j++){
 * arr[i][j] = arr[i-1][j]+arr[i-1][j-1];
 * }
 * }
 * //遍历打印二维数组
 * for (int i = 0; i<arr.length; i++){
 * for (int j =0; j<arr.length; j++){
 * System.out.print(arr[i][j]+"  ");
 * }
 * System.out.println();
 * }
 * }
 **/
