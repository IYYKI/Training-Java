package Day9_7_24周三.学生科目及成绩;

public class Test {
    public static void main (String [] args){
        SubjectResult s= new SubjectResult();
        s.getEnglish();
        s.getMath();
        s.getProgramdesign();
        System.out.println("总成绩为: "+ s.TotalGrade());
    }

}
