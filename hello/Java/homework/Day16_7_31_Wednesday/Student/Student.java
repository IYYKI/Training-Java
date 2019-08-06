package Day16_7_31_Wednesday.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    private String name;
    private int num;
    private Subject[] sub;
    private int sum = 0;

    public Student(String name, int num, Subject... sub) {
        super();
        this.name = name;
        this.num = num;
        this.sub = sub;
        for (int i = 0; i < sub.length; i++) {
            this.sum += sub[i].getGrade();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNo() {
        return num;
    }

    public void setNo(int no) {
        this.num = no;
    }

    public Subject[] getSub() {
        return sub;
    }

    public void setSub(Subject[] sub) {
        this.sub = sub;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "[name="+name+" 学号="+num+",各科成绩="+Arrays.toString(sub)+",总成绩="+sum+"]\n\n";
    }

    public static void main(String[] args) {

        Student s1 = new Student("学生",
                20,
                new Subject("English", 80),
                new Subject("Chinese", 82),
                new Subject("Math", 81));

        Student s2 = new Student("学生",
                30,
                new Subject("English", 60),
                new Subject("Chinese", 62),
                new Subject("Math", 61));

        Student s3 = new Student("学生",
                40,
                new Subject("English", 30),
                new Subject("Chinese", 32),
                new Subject("Math", 31));

        ArrayList<Object> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);
        System.out.println(al + "\n");
        System.out.println("升序		学号");
        MyComparator mc1 = new MyComparator("升序", "学号");
        Collections.sort(al, mc1);
        System.out.println(al + "\n");
        System.out.println("降序		学号");
        MyComparator mc2 = new MyComparator("降序", "学号");
        Collections.sort(al, mc2);
        System.out.println(al + "\n");
        System.out.println("升序		总成绩");
        MyComparator mc3 = new MyComparator("升序", "总成绩");
        Collections.sort(al, mc3);
        System.out.println(al + "\n");
        System.out.println("降序		总成绩");
        MyComparator mc4 = new MyComparator("降序", "总成绩");
        Collections.sort(al, mc4);
        System.out.println(al + "\n");
    }

    public static class MyComparator implements Comparator {
        private String order;
        private String field;

        public MyComparator(String order, String field) {
            this.order = order;
            this.field = field;
        }

        @Override
        public int compare(Object o1, Object o2) {
            Student stu1 = (Student) o1;
            Student stu2 = (Student) o2;
            int result = 0;
            if ("?  ".equals(field)) {
                result = stu1.getNo() - stu2.getNo();
            } else if (" ?? ".equals(field)) {
                result = stu1.getSum() - stu2.getSum();
            }
            if ("    ".equals(order)) {
                result = -result;
            }
            return result;
        }
    }

    public static class Subject {
        private String name;
        private int grade;

        public Subject(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        @Override
        public String toString() {
            return "科目: " + name + ",成绩=" + grade + " ";
        }
    }
}