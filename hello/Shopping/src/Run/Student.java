package Run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Student {
    private String name;
    private int no;
    private Subject[] sub;
    private int sum = 0;

    public Student(String name, int no, Subject... sub) {
        super();
        this.name = name;
        this.no = no;
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
        return no;
    }

    public void setNo(int no) {
        this.no = no;
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
        return "Student [name=" + name + ", no=" + no + ", sub=" + Arrays.toString(sub) + ", sum=" + sum + "]\n";
    }

    public static void main(String[] args) {

        Student s1 = new Student("qwl", 20, new Subject("English", 80), new Subject("Chinese", 82),
                new Subject("Math", 81));

        Student s2 = new Student("qwl", 40, new Subject("English", 60), new Subject("Chinese", 62),
                new Subject("Math", 61));

        Student s3 = new Student("qwl", 30, new Subject("English", 30), new Subject("Chinese", 32),
                new Subject("Math", 31));

        ArrayList<Object> al = new ArrayList<>();
        al.add(s1);
        al.add(s2);
        al.add(s3);
        System.out.println(al + "\n");
        System.out.println("ÉýÐò		Ñ§ºÅ");
        MyComparator mc1 = new MyComparator("ÉýÐò", "Ñ§ºÅ");
        Collections.sort(al, mc1);
        System.out.println(al + "\n");
        System.out.println("½µÐò		Ñ§ºÅ");
        MyComparator mc2 = new MyComparator("½µÐò", "Ñ§ºÅ");
        Collections.sort(al, mc2);
        System.out.println(al + "\n");
        System.out.println("ÉýÐò		×Ü³É¼¨");
        MyComparator mc3 = new MyComparator("ÉýÐò", "×Ü³É¼¨");
        Collections.sort(al, mc3);
        System.out.println(al + "\n");
        System.out.println("½µÐò		×Ü³É¼¨");
        MyComparator mc4 = new MyComparator("½µÐò", "×Ü³É¼¨");
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
            return "Subject [name=" + name + ", grade=" + grade + "]";
        }
    }
}