package HomeWork.HW;

public class RunnerTest {
    private  int number;
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public static void main(String[] args) {
        // 学生竞赛跑步
        Thread t1 = new Thread(new HomeWork_StudentRun());
        Thread t2 = new Thread(new HomeWork_StudentRun());
        Thread t3 = new Thread(new HomeWork_StudentRun());
        t1.start();
        t2.start();
        t3.start();
        // 死锁


    }
}