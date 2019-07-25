package Day9_7_24周三.接口Area;
//看错了，本来是写三角形的 周长跟面积了，第二第三看差了；
public class MyTriangle implements Area {
    double width;
    double height;
    MyTriangle(double width,double height){
        this.width=width;
        this.height=height;
    }
    public double calculateArea() {
        return width*height/2;
    }
}
