public class ATest {
    public static void main(String[] args) {
        Student s1 = Student.getInstance();
        Student s2 = Student.getInstance();
        System.out.println(s1==s2);

    }
}
//懒汉式
class Student {
    private static Student student;
    private Student(){
    }
    public static Student getInstance(){
        if (student==null){
            student = new Student();
        }
        return student;
    }
}
//饿汉式

class Tercher{
    private Tercher(){}
}