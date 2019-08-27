public class Day8_22 {
    public static void main(String[] args) {
        print(100);
        System.out.println(add(100));
        o(100);
    }
    //1打印到100
    public static void print(int n){
        if (n==1){
            System.out.println(1);
        }else {
            print(n-1);
            System.out.println(n);
        }
    }
        //1+到100
        public static int add(int n) {
            if (n==1){
                return 1;
            }else {
                return add(n-1)+n;
            }
        }
        //100打印到1
    public static void o(int n){
        if (n==1){
            System.out.println(1);
        }else {
            System.out.println(n);
            print(n-1);

        }
    }
}
