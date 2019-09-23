package Day2_7_15周一;

public class Homework5 {
    public static void main(String[] args) {

        int[] arr = {3, 9, 5, 8, 2, 87};
        for (int i = 0; i <= 5; i++) {
            /**
             *      遍历
             * **/
            System.out.println(arr[i]);
        }


        int[][] in = new int[2][3];
        in[0][0] = 1;
        in[0][1] = 2;
        in[0][2] = 3;
        in[1][0] = 4;
        in[1][1] = 5;
        in[1][2] = 6;
        for (int a = 0; a < in.length; a++) {
            for (int j = 0; j < in[a].length; j++) {
                System.out.println("二维数组: " + in[a][j]);
            }
        }
    }
}