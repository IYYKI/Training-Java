package Day9_7_24周三.接口Area;


class MyRectangle implements Area{
    double width;
    double height;
    MyRectangle(double width,double height){
        this.width=width;
        this.height=height;
    }
    public double calculateArea(){
        return width*height;
    }
}
