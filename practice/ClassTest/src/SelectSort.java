
import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {123, 2312, 125, 45, 1, 342, 65, 7, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //ð�����򣺱Ƚϴ�����O(n^2)      ����������O(n^2)
    //����ԭ���������������ȣ����ǰ������Ⱥ���������򽻻�λ�ã�һ������������ð��������棬��������һ��
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//����ѭ���Ƚϵ�����
            //�����������ڱȽ�
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {//��Ҫ����λ��
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }


    //��������  �Ƚϴ���O��n^2��  ����������O��n^2��
    //����ԭ����δ����Ԫ�ذ���������Ԫ�ع�����뵽������Ԫ���У��Դ�����ֱ��δ����Ԫ�ظ���Ϊ0
    public static void insertSort(int[] arr) {
        //�Ƚ�������δ����Ԫ�ظ�����   2 4  3 1
        for (int i = 1; i < arr.length; i++) {//δ����
            //��δ����Ԫ�غ�ǰ������������Ԫ�رȽ�
            for (int j = i - 1; j >= 0; j--) {//������
                if (arr[j + 1] < arr[j]) {//������Ԫ�ش���δ����Ԫ��
                    //����λ��
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                } else {
                    break;
                }
            }
        }
    }
    //ѡ������ �Ƚϴ���O(n^2)  ��������O(n)
    //����ԭ����n�������ҵ���С�ķŵ���ǰ�棬�ҳ��ڶ�С�ķŵ��ڶ���λ�ã�һ������
    public static void selectSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {//���ƱȽϴ���
            int min=i;//����iΪ��С��������  min������С���� ����
            //Ѱ�ҸôαȽ�����С��
            for(int j=i;j<arr.length;j++) {
                if(arr[min]>arr[j]) {
                    min=j;
                }
            }
            //����С������ǰ����λ������
            int tmp=arr[min];
            arr[min]=arr[i];
            arr[i] = tmp;
        }
    }
    //��������  O(log2n)
    //����ԭ���ҵ�������м�ֵ �ѱ��м�ֵС������߷� ���м�ֵ������ұ߷� ����������ִ��ͬ���Ĳ���
    public static void quickSort(int[] arr,int low,int high) {
        int mid = middle(arr, low, high);
        //ͨ���ݹ�
        if(low<high) {
            quickSort(arr, low, mid-1);
            quickSort(arr, mid+1, high);
        }
    }
    //���м�ֵ�ķ���
    public static int middle(int[] arr,int low,int high) {
        int key=arr[low];//����
        while(low<high) {
            //����λԪ�غ��м�ֵ�Ƚ� ������м�ֵ��highָ����ǰŲ�Ƚ���һ��Ԫ�أ����С��ɸ�Ԫ�طŵ���λ
            while(low<high && arr[high]>=key) {
                high--;
            }
            //˵����λԪ�ر�����С
            arr[low]=arr[high];
            while(low<high && arr[low]<=key) {
                low++;
            }
            arr[high]=arr[low];
        }
        //˵���ҵ��м�λ�� lowָ�����ڵ�λ��
        arr[low]=key;
        return low;
    }

}