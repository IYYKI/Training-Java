package Day5_7_18周四.矩形;

public class Rectangle{
    private double width;
    private double height;
    public Rectangle(double width,double height){
        this.width = width;
        this.height = height;
    }
    public Rectangle(){
        width = 3;
        height = 4;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    public double S(){
        double S=(width*height);
        return S;
    }
    public double Theperimeter(){
        double Theperimeter = ((width*height)*2);
        return Theperimeter;
    }
}
