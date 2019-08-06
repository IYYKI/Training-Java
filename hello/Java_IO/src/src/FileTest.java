package src;

import java.io.*;

public class FileTest {
    public static void main(String[] args) throws IOException , ClassNotFoundException{
        File file = new File("/Users/yao/IdeaProjects/hello/Java_IO/abc");
        write(file);
        read(file);
    }

    public static void write(File file) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        bos.write(99);
        bos.write("what f k".getBytes());
        bos.flush();
        bos.close();
    }

    public static void read(File file) throws IOException {
        BufferedInputStream bs = new BufferedInputStream(new FileInputStream(file));
        int c = bs.read();
        if (c != -1) {
            System.out.println((char) c);
        }
    }
}