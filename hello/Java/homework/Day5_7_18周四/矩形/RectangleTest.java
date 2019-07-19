package Day5_7_18周四.矩形;

public class RectangleTest {
    public static void main (String [] args){
        double S,D;
        double MJ,perimeter;
        Rectangle s = new Rectangle(1,1);
        Rectangle mj = new Rectangle();
        MJ = (s.getHeight()*s.getWidth());
        S=(s.getHeight()*s.getWidth()*2);
        System.out.println("第一个面积"+MJ);
        System.out.println("第一个周长"+S);
        D = (mj.getHeight()*mj.getWidth());
        perimeter = (mj.getHeight()*mj.getWidth()*2);
        System.out.println();
        System.out.println("第二个面积"+D);
        System.out.println("第二个周长"+perimeter);
    }
}
