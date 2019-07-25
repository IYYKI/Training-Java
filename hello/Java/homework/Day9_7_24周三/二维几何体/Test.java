package Day9_7_24周三.二维几何体;

public class Test {
    public static void main (String [] args){
        Triangle triangle = new Triangle("黑色","三角",3,4,5);
        System.out.println(triangle.getColor()+"三角形的周长为: "+triangle.getB());
        System.out.println("三角形的面积为: "+triangle.getA());
    }
}
