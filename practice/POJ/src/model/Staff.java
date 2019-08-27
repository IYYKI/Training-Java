package model;

public class Staff {
    private int id;
    private String name;
    private String sex;
    private String department;
    private int salary;


    public Staff() {
        super();
    }

    public Staff(int id, String name, String sex, String department, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.department = department;
        this.salary = salary;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "staff " +
                "[id=" + id +
                ", name=" + name +
                ", sex=" + sex +
                ", department=" +
                department +
                ", salary="
                + salary + "]";
    }


}
