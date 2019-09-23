package Day10_7_25周四.键盘读数;


import java.util.Scanner;

public class MyTest2 {
    private static void getString() {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        sc.close();
        try {
            if (result.isEmpty()) {


                throw new EmptyStringException();
            } else {
                result = result.replace(" ", "");
                if (result.matches(".*\\d+.*")) {
                    /**
                     * .点 匹配除"\n"和"\r"之外的任何单个字符 * 匹配前面的子表达式任意次。 \d 匹配一个数字字符。等价于[0-9]。 +
                     * 匹配前面的子表达式一次或多次(大于等于1次）。
                     */
                    // 如果读入的内容中包含有数字，则抛出IncludeNumberException异常
                    throw new IncludeNumberException();
                } else {
                    System.out.println(result);
                }
            }

        } catch (EmptyStringException e) {

            e.printStackTrace();
        } catch (IncludeNumberException e) {
            e.printStackTrace();
        }
        // 如果读入的是空串，则抛出InvalidInputException异常

    }

    public static void main(String[] args) throws EmptyStringException, IncludeNumberException {

        System.out.print("请输入: ");
        System.out.println();
        getString();

    }

    private static class EmptyStringException extends RuntimeException {

        private static final long serialVersionUID = 1L;
    }

    private static class IncludeNumberException extends RuntimeException {
        private static final long serialVersionUID = 1L;

    }

}