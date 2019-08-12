package HomeWork.HW4;


import java.lang.Runnable;
import java.lang.Thread;
public class GuessNumber {
    public static void main(String[] args) {
        Number number = new Number();
        number.giveNumberThread.start();
        number.guessNumberThread.start();
    }
}
class Number implements Runnable {
    int realNumber,guessNumber,min = 1,max = 100,message;
    final int SMALLER = -1,LARGER = 1,SUCCESS = 10;
    Thread giveNumberThread,guessNumberThread;
    Number() {
        giveNumberThread = new Thread(this);
        guessNumberThread = new Thread(this);
    }

    public void run() {

        for (int count = 1; true; count++) {
            if (Thread.currentThread() == giveNumberThread) {
                if (count == 1) {
                    realNumber = (int) (Math.random() * 50) + 1;
                    System.out.println("随机给你一个数为"+realNumber+",猜猜是多少");
                } else {
                    if (realNumber > guessNumber) {
                        message = SMALLER;
                        System.out.println("你猜小了");
                    } else if (realNumber < guessNumber) {
                        message = LARGER;
                        System.out.println("你猜大了");
                    } else {
                        message = SUCCESS;
                        System.out.println("恭喜,你猜对了");
                        return;
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
            }
            if (Thread.currentThread() == guessNumberThread) {
                if (count == 1) {
                    guessNumber = (min + max) / 2;
                    System.out.println("我第" + count + "次猜这个数:" + guessNumber);
                } else {
                    if (message == SMALLER) {
                        min = guessNumber;
                        guessNumber = (min + max) / 2;
                        System.out.println("我第" + count + "次猜这个数是"
                                + guessNumber);
                    } else if (message == LARGER) {
                        max = guessNumber;
                        guessNumber = (min + max) / 2;
                        System.out.println(
                                "我第" + count + "次猜这个数是" + guessNumber);
                    } else if (message == SUCCESS) {
                        System.out.println("我成功了！");
                        return;
                    }
                }
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                }
            }
        }
    }


}