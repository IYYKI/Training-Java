package Day10_7_25周四.数组十位;


import java.util.Scanner;

import java.util.Scanner;

public class ArrayTest {
    private static int[] a = new int[10];

    public static void test(int[] a, Scanner s) {

        int count = 0;
        while (count < a.length) {
            System.out.println("请输入第" + (count + 1) + "个数字");
            int it = s.nextInt();
            a[count] = it;
            count++;
            try {
                for (int i = 0; i < count; i++) {
                    if (i > 0) {
                        if (a[i - 1] == it) {
                            throw new DuplicateValueException();
                        }
                    }
                }
            } catch (DuplicateValueException e) {
                e.printStackTrace();
                count--;
            }
        }

        System.out.println("输出数组");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        test(a, s);
        NumberNotFound(a, s);
        s.close();

    }

    private static void NumberNotFound(int[] a, Scanner sc) {
        System.out.println("请输入查询数字:   ");
        int q = sc.nextInt();
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == q) {
                System.out.println("有" + a[i] + "  在第" + (i+1)  + "个位置上");
                count++;
            }
        }
        try {
            if (count == 0) {
                throw new NotFoundException();
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

    }

    public static class DuplicateValueException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public DuplicateValueException() {
            super("输入数字与数组元素重复,再次输入");
        }
    }

    public static class NotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public NotFoundException() {
            super("找不到，么得");
        }
    }

}