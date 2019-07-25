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
public class ClassRoom {
    int studentNum;
    String studentName;
    double math;
    double  english;
    double programdesign;

    public int getStudentNum() {
        return studentNum;
    }

    public String  getStudentName() {
        return studentName;
    }

    public double  getMath() {
        return math;
    }

    public double  getEnglish() {
        return english;
    }

    public double getProgramdesign() {
        return programdesign;
    }
    public ClassRoom(int studentNum, String studentName,
                   int math, int english, int programdesign){
        this.studentNum = studentNum;
        this.studentName = studentName;
        this.math = math;
        this.english = english;
        this.programdesign = programdesign;

    }
    public  double TotalGrade(){
       double TotalGrade = math+english+programdesign;
       return TotalGrade;
    }
}
