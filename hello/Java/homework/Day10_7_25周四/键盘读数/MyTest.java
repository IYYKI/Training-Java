package Day10_7_25周四.键盘读数;
import java.io.*;
class MyTest {

    public static void main(String[] args)
            throws IOException,
            EmptyStringException,
            IncludeNumberException {

        System.out.print("请输入: ");
        System.out.println();

        // 字节流
        InputStream inputStream = System.in;
        // 转换流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        // 缓冲流
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // 读一行
        String result = bufferedReader.readLine();
        // 去空格
        String trim = result.trim();
        // 如果读入的是空串，则抛出InvalidInputException异常
        if(trim.isEmpty()) {
            bufferedReader.close();
            throw new EmptyStringException();
        }
        // 如果读入的内容中包含有数字，则抛出IncludeNumberException异常
        if(trim.matches(".*\\d+.*")) {
            /**
             * .点 匹配除"\n"和"\r"之外的任何单个字符
             * * 匹配前面的子表达式任意次。
             * \d 匹配一个数字字符。等价于[0-9]。
             * + 匹配前面的子表达式一次或多次(大于等于1次）。
             */
            bufferedReader.close();
            throw new IncludeNumberException();
        }
        bufferedReader.close();
    }
}