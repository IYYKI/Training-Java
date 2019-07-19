package Day2_7_15周一;

public class Homework4 {
    public static void main(String[] args) {
        double arr[] = new double[]{1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 100.0}; // 定义一个数组
        double min = arr[0]; // 把数据中的第1个元素存min
        for (int i = 1; i < arr.length; i++) { // 从第二个元素开始遍历数组
            if (arr[i] < min) {  // 假如元素小于min 就把当前值赋值给min
                min = arr[i];
            }
        }
        System.out.println("数组中的最小值：" + min);

    }
}