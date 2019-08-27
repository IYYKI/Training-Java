package Fifteen_Sequence;

public class Sequence {
    public static void main(String[] args) {
        /***Sequence s = new Sequence();
         System.out.println("数列2/1，3/2，5/3，8/5，13/8，21/13···的前20项之和为：");
         System.out.println(s.sequence());
         }
         public double sequence(){
         double a = 1;
         double b = 1;
         double c = 1;
         double sum= 0;

         for (int i=0; i<20;i++){
         c=a+b;
         a=b;
         b=c;
         sum+=b/a;
         }
         return sum;
         }**/

    s((double)20);
    }

    public static void s(double v) {
        double sum = 0;
        double fz = 2;
        double fm = 1;
        for (int i = 0; i < 20; i++) {//循环20此将每一项进行求和
            //数列中的每一项数据
            double x = fz / fm;//2/1
            sum+=x;

            double tmp=fm;
            fm = fz;//2
            fz = tmp+fz;//3
        }
        System.out.println("前20项和为："+sum);
    }
}
/**
 * 斐波那契
 * <p>
 * <p>
 * public class Test {
 * <p>
 * public static void main(String[] args) {
 * <p>
 * System.out.println(add(20));
 * <p>
 * }
 * <p>
 * //求斐波那契(fibonacci)数列
 * <p>
 * public static double fibonacci(int pos) {
 * <p>
 * if(pos==1||pos==2) {
 * <p>
 * return 1;
 * <p>
 * }
 * <p>
 * else {
 * <p>
 * return fibonacci(pos-1)+fibonacci(pos-2);
 * <p>
 * }
 * <p>
 * }
 * <p>
 * //求和
 * <p>
 * public static double add(int i) {
 * <p>
 * String output ="";
 * <p>
 * double sum = 0;
 * <p>
 * int j = i+2;
 * <p>
 * for(i=3;i<=j;i++) {
 * <p>
 * sum += fibonacci(i)/fibonacci(i-1);	//求和
 * <p>
 * output += (int)fibonacci(i)+"/"+(int)fibonacci(i-1)+ "+";//输出控制表达式
 * <p>
 * }
 * <p>
 * System.out.println(output.substring(0, output.length()-1)+ "=");//打印表达式
 * <p>
 * return sum;
 * <p>
 * }
 * <p>
 * }
 **/
