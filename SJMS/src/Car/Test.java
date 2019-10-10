package Car;

public class Test {
    public static void main(String[] args) {
        CarFactory carFactory = new LinkCarFactory();
        System.out.println(carFactory.getEngine());
        System.out.println(carFactory.getSteering());
        System.out.println(carFactory.getWhell());
    }
}
