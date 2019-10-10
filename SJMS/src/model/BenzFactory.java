package model;

public class BenzFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new BenzCar();
    }
}
