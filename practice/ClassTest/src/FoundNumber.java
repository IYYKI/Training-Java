import java.util.Arrays;

public class FoundNumber {
    public static void main(String[] args) {
        //��һ��101λ������ �������1-100֮�䲻�ظ�����101�������һ��1-100֮�����
        //����˳�� ����㷨������ظ�����
        int [] arr = new int[101];
        for (int i =0;i<100;i++){
            arr[i] = i+1;
        }
        int rand = (int)(Math.random()*100+1);
        arr[100]=rand;
        System.out.println(Arrays.toString(arr));
        for (int i=1; i<1000; i++){
            int index = (int)(Math.random()*100+1);
            int tmp = arr[0];
            arr [0] = arr[index];
            arr[index]=tmp;
        }
        found(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void found(int [] arr){
        int [] brr = new int [100];
        //arr��������1-100֮�����
        for (int i=0; i<arr.length; i++){
            int dex = arr[i]-1;//99
            brr[dex]++;
            if (brr[dex]==2){
                System.out.println("����ظ��������: "+ brr);
            }
        }
    }
}
