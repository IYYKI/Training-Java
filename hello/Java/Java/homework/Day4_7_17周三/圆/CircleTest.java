package Day4_7_17周三.圆;

public class CircleTest {
    private double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public CircleTest(double r) {
        super();
        this.r = r;
    }

    public void MJ() {
        System.out.println("圆的面积为：" + (3.14 * this.getR() * this.getR()));
    }

    public void ZC() {
        System.out.println("圆的周长为：" + (2 * 3.14 * this.getR()));
    }
}