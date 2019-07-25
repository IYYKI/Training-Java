package Day9_7_24周三.接口Area;

public class Test {
    public static void main(String[] args) {
        //圆的半径
        MyCircle circle = new MyCircle(4);
        //圆的面积
        System.out.println("圆的面积为: " + circle.calculateArea());
        //矩形的长，宽
        MyRectangle rectangle = new MyRectangle(2, 4);
        //矩形的面积
        System.out.println("矩形的面积为: " + rectangle.calculateArea());
        /**奶奶的第二第三题看错了
         //三角形的长,宽
         MyTriangle triangle = new MyTriangle(2.3,4.5);
         //三角形的面积
         System.out.println("三角形的面积为: "+triangle.calculateArea());
         }**/
    }
}
