import java.util.Arrays;

public class BubbleSortVoid {
    public static void main(String[] args) {
        int arr[] = {1,3,4,7,9,2,123,22};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void BubbleSort(int arr[]) {
        for (int i = 0; i<arr.length-1; i++){
            for (int j = 0; j<arr.length-i-1; j++){
                if (arr[j]>arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }
    }
}
//8月22日周四 下午3点半 冒泡排序 拿下！！！！