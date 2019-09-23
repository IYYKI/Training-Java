package Day9_7_24周三.学生科目及成绩;

public class SubjectResult {
    double math;
    double english;
    double programdesign;

    public double getMath() {
        return math;
    }

    public double getEnglish() {
        return english;
    }

    public double getProgramdesign() {
        return programdesign;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

    public void setProgramdesign(double programdesign) {
        this.programdesign = programdesign;
    }

    public SubjectResult(){
        this.math = 80.0;
        this.english = 90.0;
        this.programdesign = 100.0;

        System.out.println("数学"+math);
        System.out.println("英语"+english);
        System.out.println("程序设计"+programdesign);
    }
    public double TotalGrade() {
        double TotalGrade = math + english + programdesign;
        return TotalGrade;
    }
}
