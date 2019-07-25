package Day9_7_24周三.学生科目及成绩;

public class Student {
    public static void main (String [] args){
        ClassRoom student = new ClassRoom(1,"张三",94,60,72);
        System.out.println("学号： "+student.studentNum);
        System.out.println("姓名： "+student.studentName);
        System.out.println("数学成绩为： "+student.math);
        System.out.println("英语成绩为： "+student.english);
        System.out.println("程序与设计成绩为： "+student.programdesign);
        System.out.println("学生总成绩为： "+student.TotalGrade());


    }
}
