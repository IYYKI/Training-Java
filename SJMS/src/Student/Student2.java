package Student;

public class Student2 {
    public static Student2 student2;
    private Student2(){

    }
    public static Student2 getInstance(){
        if (student2==null){
            student2 = new Student2();
        }
        return student2;
    }
}
