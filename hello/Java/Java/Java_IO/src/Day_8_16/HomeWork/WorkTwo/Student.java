package Day_8_16.HomeWork.WorkTwo;

public class Student {
    private int id;
    private String name;
    private String sex;
    private int age;


    public Student() {
        super();
    }


    public Student(int id, String name, String sex, int age) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getSex() {
        return sex;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }



}
