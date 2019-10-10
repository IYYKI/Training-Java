package model;

public class Test {
    public static void main(String[] args) {
        CarFactory factory=new BMWFactory();
        Car car=factory.createCar();
        System.out.println(car.getClass());
    }
}
