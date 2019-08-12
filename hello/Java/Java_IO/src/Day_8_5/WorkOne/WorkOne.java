package Day_8_5.WorkOne;

import java.io.*;
import java.util.Scanner;

public class WorkOne {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/yao/IdeaProjects/hello/Java_IO/src/Day_8_5/WorkOne/file");
        write(file);
    }

    public static void write(File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        Scanner in = new Scanner(System.in);
        String str;
        while (true) {
            System.out.println("请输入字符串：");
            String str2 = in.next();
            str = str2.toUpperCase();
            if (str.endsWith("#")) {
                str = str.substring(0, str.length() - 1);
                bw.write(str);
                bw.newLine();
                break;
            }
            bw.write(str);
            bw.newLine();
        }
        System.out.println("The And");
        bw.flush();
        bw.close();
    }
}
