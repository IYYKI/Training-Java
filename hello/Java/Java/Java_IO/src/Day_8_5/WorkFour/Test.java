package Day_8_5.WorkFour;

import java.io.*;

public class Test {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        File file = new File("/Users/yao/IdeaProjects/hello/Java_IO/src/Day_8_5/WorkFour/LookFile");
        write(file);
        read(file);
    }

    public static void write(File file) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        BeFor_TestFile m = new BeFor_TestFile("root","123456","男","你是我天边最美的云彩");
        oos.writeObject(m);

        oos.flush();
        oos.close();
    }

    public static void read(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        BeFor_TestFile B = (BeFor_TestFile)ois.readObject();
        System.out.println(B);
        ois.close();
    }
}
