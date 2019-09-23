package Day9_7_24周三.二维几何体;

public class Triangle extends GeometricObject {
    private double one;
    private double two;
    private double three;
    public Triangle(String color,String shenti,double one,double two,double three){
        super(color,shenti);

        this.one = one;
        this.two = two;
        this.three = three;
    }

    @Override
    public double getA() {
        double p = (one+two+three)/2;
        double s = Math.sqrt(p*(p-one)*(p-two)*(p-three));
        return s;
    }
    public double getB(){
        return one+two+three;
    }
}
