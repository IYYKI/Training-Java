package Student;

public class Test2 {
    public static void main(String[] args) {
        Student2 student = Student2.getInstance();
        Student2 student2 = Student2.getInstance();
        System.out.println(student==student2);
    }
}
