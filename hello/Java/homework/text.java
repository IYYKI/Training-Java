public class text {
    public static void main (String [] args){
        int a[]={1,2,6,8,94,4};
        change(a);
        System.out.println(a[5]);
    }
    public static void change(int [] a){
        a[5] = 18;
        System.out.println(a [5]);
    }
}
