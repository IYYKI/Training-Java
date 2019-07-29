package Day10_7_25周四.正数;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException{
        System.out.print("请输入： ");
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        try {
            System.out.println(compute(num1, num2));
            throw new ArrayIndexOutOfBoundsException(-1);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("不得行");
        } finally {
            scanner.close();
        }
    }

    public static double compute(int num1, int num2) throws ArithmeticException {
        double result;
        try {
            result = num1 / num2;
        } catch (ArithmeticException e) {
            throw new InvalidInputException();
        }
        return result;
    }
}

