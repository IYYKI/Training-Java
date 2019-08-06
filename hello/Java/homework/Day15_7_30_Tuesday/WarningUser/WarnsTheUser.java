package Day15_7_30_Tuesday.WarningUser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;

public class WarnsTheUser {
    public static void main(String [] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("java.lang.String");
        String s = scanner.next();
        Class cls = Class.forName(s);
        Method [] methods = cls.getDeclaredMethods();
        for (Method method:methods){
            System.out.println(method);
        }
        Constructor [] constructors = cls.getDeclaredConstructors();
        for (Constructor c:constructors){
            System.out.println(c);
        }
        Field [] fields = cls.getDeclaredFields();
        for (Field field:fields){
            System.out.println(field);
        }
    }
}
