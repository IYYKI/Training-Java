package Day_8_5.WorkTwo;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class WorkTwo {

    public static void main(String[] args) throws IOException {
        File dir = new File("/Users/Yao/Desktop/Myfile");
        readFile(dir);
    }

    public static void readFile(File dir) {
        File[] fs = dir.listFiles(new Myfilte());
        for (File f : fs) {
            if (f.isDirectory()) {
            }
            System.out.println(f.getName());
            System.out.println(f.getPath());
            long time = f.lastModified();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String str = sdf.format(time);
            System.out.println(str);
            System.out.println(f.length() + "byte");
            System.out.println();
        }
    }
}


class Myfilte implements FileFilter {
    public boolean accept(File pathname) {
        if (pathname.getName().endsWith(".txt")) {
            return true;
        }
        return false;
    }
}
