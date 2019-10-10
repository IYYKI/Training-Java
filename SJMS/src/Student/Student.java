package Student;

/*
 * 单例模式（singleton）：保证一个类只有一个对象产生
 * 饿汉式  类加载的时候就准备好对象了
 * */
public class Student {
    //初始化
    public static Student student = new Student();

    private Student() {
    }

    public static Student getInstance() {
        return student;
    }

}
