package BenzAndBMW;

//简单工厂
public class CarFactory {
    public Car creatCar(String message) {
        if ("BMW".equals(message)) {
            return new BMWCar();
        } else if ("Benz".equals(message)) {
            return new BMWCar();
        } else {
            return null;
        }
    }
}
