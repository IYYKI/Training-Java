package MonkeyEat;

public class Eat {
    public static void main(String[] args) {
        eat();
    }

    public static void eat() {
        int peach = 1;
        for (int i = 0; i < 9; i++) {
            peach = (peach + 1) * 2;
        }
        System.out.println(peach);
    }
}
/**
 * 使用递归方法
 *
 *
 * public static vod eat(int n){
 * if(n==1){
 * return 1;
 * }else
 * return(eat(n-1)+1)*2;
 * }
 **/