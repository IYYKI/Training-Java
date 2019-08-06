package Day16_7_31_Wednesday.比较器;

public class Person {
    private String name;
    private int id;
    private int number;

    public Person(String name, int id, int number) {
        super();
        this.name = name;
        this.id = id;
        this.number = number;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "name="+name+",id="+id+",number="+number+"\n";
    }
}