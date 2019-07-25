package Day9_7_24周三.二维几何体;

/**
 * 编写一个抽象的二维几何体类 GeometricObject ，
 * 其中定义周长和面积方法，和形体颜色属性，
 * 再编写三角形类继承 GeometricObject 类，
 * 有三个边长属性，编写矩形类继承GeometricObject 类，有长和宽属性。
 **/
public abstract class GeometricObject {
    private  String color;
    private String shenti;
    public GeometricObject(String color,String shenti){
        this.color= color;
        this.shenti = shenti;
    }
    public abstract double getA();
    public abstract double getB();
    public String getColor(){
        return color;
    }

    public String getShenti() {
        return shenti;
    }
}
