package MT.model;

public class Food {
    private int foodId;
    private String name;
    private double price;
    private String pic;// 图片

    public Food(int foodId, String name, double price, String pic) {
        super();
        this.foodId = foodId;
        this.name = name;
        this.price = price;
        this.pic = pic;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
