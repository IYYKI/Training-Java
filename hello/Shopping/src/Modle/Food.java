package Modle;

public class Food {
    private String name;
    private int num;

    public Food(String name,int num) {
        this.name = name;
        this.num = num;
    }

    public void addNum(int num) {
        this.num +=num;
    }
    public void reduceNum(int num) {
        this.num -=num;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNum() {
        return num;
    }
    public void setNum(int num) {
        this.num = num;
    }

}