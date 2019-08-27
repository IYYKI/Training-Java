package TTShuZu;

public class SuNum {
    public static void main(String[] args) {
        int arr [] = {1,231,1234,4324,45312};
    }
    public static void pr20(int arr []){
        //最大元素
        int max = arr[0];
        for (int i = 1; i<arr.length; i++){
            if (max <arr[i]){
                 max=i;

            }
        }
        //交换位置
        int tmp = arr[0];
        arr[0]=arr[max];
        arr[max]=tmp;

        //最小
        int min = 0;
        for (int i =1; i<arr.length;i++){
            if (arr[min]>arr[i]){

            }
        }
        //交换位置

    }
}
