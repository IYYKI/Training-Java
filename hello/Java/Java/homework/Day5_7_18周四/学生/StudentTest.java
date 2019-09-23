package homework.Day5_7_18周四.学生;

import Day5_7_18周四.学生.Student;

public class StudentTest {
    public static void main (String [] args){
        double PJ;
        Day5_7_18周四.学生.Student s1 = new Student(37,"张三",'男',18,90);
        System.out.println();
        Student s2 = new Student(38,"老狗",'女',18,95);
        System.out.println(s1);
        System.out.println(s2);
        PJ = (s1.getJava()+s1.getJava()/2);
        System.out.println("平均分"+PJ);
    }
}
