package Day16_7_31_Wednesday.Student;

public class ArrayListForStudentTest {
    public static void main (String []args){
        Student.Subject subject  = new Student.Subject("语文",80);
        Student.Subject subject1 = new Student.Subject("数学",81);
        Student.Subject subject2 = new Student.Subject("英语",82);
        Student student = new Student("yyk",20,subject,subject1,subject2);
        System.out.println(student);

    }
}
