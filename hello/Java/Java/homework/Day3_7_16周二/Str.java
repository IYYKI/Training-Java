package Day3_7_16周二;

public class Str {
    static void str() {
        double arr[] = new double[]{0, 1, -1, -20, 30, 25, 100}; // 定义一个数组
        double little = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < little) {
                little = arr[i];
            }
        }
        System.out.println("最小值为： " + little);
    }
}