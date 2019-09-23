package Studen.model;

public class Student {
    private int id;
    private String name;
    private String ClassRoom;
    private double results;

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

    public String getClassRoom() {
        return ClassRoom;
    }

    public void setClassRoom(String classRoom) {
        ClassRoom = classRoom;
    }

    public double getResults() {
        return results;
    }

    public void setResults(double results) {
        this.results = results;
    }
    public Student(int id, String name, String classRoom, double results) {
        this.id = id;
        this.name = name;
        ClassRoom = classRoom;
        this.results = results;
    }

    public Student() {
        super();
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", ClassRoom=" +ClassRoom + ", results=" + results + "]";
    }


}

