
import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int arr[] = {123, 2312, 125, 45, 1, 342, 65, 7, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序：比较次数：O(n^2)      交换次数：O(n^2)
    //基本原理：相邻两数两两比，如果前面的数比后面的数大则交换位置，一趟下来最大的数冒到了最后面，就象气泡一样
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {//控制循环比较的趟数
            //控制两两相邻比较
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {//需要交换位置
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }


    //插入排序  比较次数O（n^2）  交换次数：O（n^2）
    //基本原理：将未排序元素按照已排序元素规则插入到已排序元素中，以此类推直到未排序元素个数为0
    public static void insertSort(int[] arr) {
        //比较趟数（未排序元素个数）   2 4  3 1
        for (int i = 1; i < arr.length; i++) {//未排序
            //将未排序元素和前面所有已排序元素比较
            for (int j = i - 1; j >= 0; j--) {//已排序
                if (arr[j + 1] < arr[j]) {//已排序元素大于未排序元素
                    //交换位置
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                } else {
                    break;
                }
            }
        }
    }
    //选择排序 比较次数O(n^2)  交换次数O(n)
    //基本原理：在n个数中找到最小的放到最前面，找出第二小的放到第二个位置，一次类推
    public static void selectSort(int[] arr) {
        for(int i=0;i<arr.length-1;i++) {//控制比较次数
            int min=i;//假设i为最小数的索引  min保存最小数的 索引
            //寻找该次比较中最小数
            for(int j=i;j<arr.length;j++) {
                if(arr[min]>arr[j]) {
                    min=j;
                }
            }
            //将最小数和最前面这位数交换
            int tmp=arr[min];
            arr[min]=arr[i];
            arr[i] = tmp;
        }
    }
    //快速排序  O(log2n)
    //基本原理：找到数组的中间值 把比中间值小的往左边放 比中间值大的往右边放 对左右两边执行同样的操作
    public static void quickSort(int[] arr,int low,int high) {
        int mid = middle(arr, low, high);
        //通过递归
        if(low<high) {
            quickSort(arr, low, mid-1);
            quickSort(arr, mid+1, high);
        }
    }
    //找中间值的方法
    public static int middle(int[] arr,int low,int high) {
        int key=arr[low];//枢轴
        while(low<high) {
            //将高位元素和中间值比较 如果比中间值大，high指针往前挪比较下一个元素，如果小则吧该元素放到低位
            while(low<high && arr[high]>=key) {
                high--;
            }
            //说明高位元素比枢轴小
            arr[low]=arr[high];
            while(low<high && arr[low]<=key) {
                low++;
            }
            arr[high]=arr[low];
        }
        //说明找到中间位置 low指针所在的位置
        arr[low]=key;
        return low;
    }

}