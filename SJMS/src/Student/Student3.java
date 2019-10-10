package Student;
//内部类单例
public class Student3 {
    private static Box box =new Box();
    private Student3(){
    }
    private static class Box{

    }
    private static Box getInstance(){
        return box;
    }

}
