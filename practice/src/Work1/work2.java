package Work1;

import java.util.Scanner;

public class work2 {
    public static void main(String[] args) {
     System.out.println("输入半径");
     Scanner scan = new Scanner(System.in);
     int r = scan.nextInt();
     double zj , zc , mj;
     zj = r * 2 ;
     zc = Math.PI * r * 2;
     mj = Math.PI*(r*r);
        System.out.println("该圆直径为：" + zj);
        System.out.println("该圆周长为：" + zc);
        System.out.println("该圆面积为：" + mj);


    }
}
