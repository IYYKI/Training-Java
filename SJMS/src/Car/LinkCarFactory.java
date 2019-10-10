package Car;

public class LinkCarFactory implements CarFactory {

    @Override
    public Whell getWhell() {
        return new Whell1();
    }

    @Override
    public Engine getEngine() {
        return new HondaEngine();
    }

    @Override
    public BSteering getSteering() {
        return new BSteering();
    }
}
