package BenzAndBMW;

public class Test {
    public static void main(String[] args) {
        Car car = new CarFactory().creatCar("Benz");
        System.out.println(car.getClass());
    }
}
