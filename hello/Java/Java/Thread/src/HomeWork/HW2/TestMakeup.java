package HomeWork.HW2;

public class TestMakeup {
    public static void main(String[] args) {
        new Thread(new Makeup(0,"张柏芝")).start();
        new Thread(new Makeup(1,"王菲")).start();
    }
}
