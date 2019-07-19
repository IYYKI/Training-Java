package Day5_7_18周四.学生;

public class Student {
    private int no;
    private String name;
    private char sex;
    private int age;
    private double java;
    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public double getJava() {
        return java;
    }
    public Student(){

    }

    public Student (int no, String name, char sex, int age,double java){
        this.no = no;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.java = java;
        System.out.println("学号: "+no);
        System.out.println("名字: "+name);
        System.out.println("性别: "+sex);
        System.out.println("年龄: "+age);
        System.out.println("成绩: "+java);
    }
}
