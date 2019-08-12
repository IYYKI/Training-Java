package Day_8_5.WorkThree;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WorkThree {

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/yao/IdeaProjects/hello/Java_IO/src/Day_8_5/WorkThree/a" );
        write(file);
        read(file);
    }

    public static void write(File file) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输出字符串3.1415926");
        String str = in.next();
        FileWriter fw = new FileWriter(file);
        fw.write(str);
        fw.flush();
        fw.close();
    }

    public static void read(File file) throws IOException {
        FileReader fr = new FileReader(file);
        char[] c = new char[(int)file.length()];
        fr.read(c);
        String str = new String(c).trim();
        double pi = Double.valueOf(str);
        System.out.println(pi);
        fr.close();
    }

}
