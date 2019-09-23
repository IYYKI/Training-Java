package DMJ4;

public class Pet {

    private int id;
    private String name;
    private String color;
    private double price;
    private String species;

    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", color=" + color + ", price=" + price + ", species=" + species
                + "]";
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

