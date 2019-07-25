package Day9_7_24周三.接口Area;

class MyCircle implements Area{
    double radius=0;//半径
    final double PI=3.1415926;
    MyCircle(double radius){
        this.radius=radius;
    }
    public double calculateArea(){
        return PI*radius*radius;
    }
}
