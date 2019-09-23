package Day5_7_18周四.步长;

public class Printer {
    public void output(int n){
        for (int i  =1 ;i<=n;i++){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public void output(int m,int n){
        for (int i = m ; i<=n ; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public void output(int m, int n , int p){
        for (int i = m; i<= n; i+=p){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
