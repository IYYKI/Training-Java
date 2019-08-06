package Day10_7_25周四.正数;

import java.util.Scanner;


import java.util.InputMismatchException;

public class ExceptionTest {
    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {

        try {
            System.out.print("请输入第一个数字： ");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            int num1 = check(getNum(sc));
            System.out.print("请输入第二个数字： ");
            System.out.println();
            int num2 = check(getNum(sc));
            System.out.println(compute(num1, num2));
        } catch (InvalidInputException e) {
            e.printStackTrace();
        }
    }

    private static int check(int num) {

        if (num < 0) { throw new InvalidInputException();
        } else {
            return num;
        }
    }

    private static int getNum(Scanner sc) {

        try {
            int num = sc.nextInt();
            return num;
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }
    }

    private static int compute(int num1, int num2) {
        int result;
        try {
            result = num1 / num2;
            return result;
        } catch (ArithmeticException e) {
            throw new InvalidInputException();
        }

    }

    private static class InvalidInputException extends ArithmeticException {
        private static final long serialVersionUID = 1L;

        public InvalidInputException() {
            super("You must enter positive number");
        }
    }
}

