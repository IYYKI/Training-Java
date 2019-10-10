package model;

public class BMWFactory implements CarFactory{

    @Override
    public Car createCar() {
        return new BMWCar();
    }
}
