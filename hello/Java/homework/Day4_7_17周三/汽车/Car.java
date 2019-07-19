package Day4_7_17周三.汽车;

public class Car {
    private String brand;
    private String color;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void run(){
        System.out.println("我已经开动了");
    }
    public void showInfo(){
        System.out.println("商标: "+brand);
        System.out.println("颜色: "+color);

    }
}
