package Day9_7_24周三.学生科目及成绩;

/**
 * 4.
 * 设计一个学生类，
 * 属性包括学号、
 * 姓名及所学的数学、
 * 英语及程序设计3门课程；
 * 课程都有名字和成绩；
 * 在学生类中完成方法输出学生的姓名及3门课程的总成绩。
 **/
public class Student {
    private static class Courses {
        private String name;
        private double results;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getResults() {
            return results;
        }

        public void setResults(double results) {
            this.results = results;
        }

        public Courses(String name, double results) {
            this.name = name;
            this.results = results;

        }
    }



    private String name;
    private int number;
    private Courses[] courses;

    public String getName() {
        return name; }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Student(String name, Courses...args) {
        courses = args;
        double sum = 0;
        for (int i = 0; i < courses.length; i++) {
            sum += courses[i].getResults();
            System.out.println(courses[i].getName() + courses[i].getResults());
        }
        System.out.println(sum + " " + name);
    }



    public static void main(String[] args) {
        Courses english = new Courses("English", 66);
        Courses math = new Courses("Math", 66);
        Courses programdesign = new Courses("programdesign", 66);
        Student student = new Student("吴亦凡", english, math, programdesign);
    }

}
