package Day16_7_31_Wednesday.Stone;

public class Stone {
    private String name;
    public Stone(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){
        return "Stone (name: " + name + ")";
    }
}