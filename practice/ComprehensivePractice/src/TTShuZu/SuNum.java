package TTShuZu;

public class SuNum {
    public static void main(String[] args) {
        int arr [] = {1,231,1234,4324,45312};
    }
    public static void pr20(int arr []){
        //���Ԫ��
        int max = arr[0];
        for (int i = 1; i<arr.length; i++){
            if (max <arr[i]){
                 max=i;

            }
        }
        //����λ��
        int tmp = arr[0];
        arr[0]=arr[max];
        arr[max]=tmp;

        //��С
        int min = 0;
        for (int i =1; i<arr.length;i++){
            if (arr[min]>arr[i]){

            }
        }
        //����λ��

    }
}
