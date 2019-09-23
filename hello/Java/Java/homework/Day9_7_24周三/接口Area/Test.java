package Day9_7_24周三.接口Area;

public class Test {
    public static void main(String[] args) {
        //圆的半径
        MyCircle circle = new MyCircle(4);
        //圆的面积
        System.out.println("圆的面积为: " + circle.ShapeArea());
        //矩形的长，宽
        MyRectangle rectangle = new MyRectangle(2, 4);
        //矩形的面积
        System.out.println("矩形的面积为: " + rectangle.ShapeArea());
    }
}
