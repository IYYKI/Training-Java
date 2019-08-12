package HomeWork.HW4;


import java.util.Random;

public class sd {

    public static void main(String[] args) {
        RandomNum rannum=new RandomNum();
        Thread guessed=new Thread(rannum);
        guessed.start();
        try {
            Thread.sleep(100);
            RandomNum intnum=new RandomNum();
            Thread guess=new Thread(intnum);
            //new Thread(guess,"guessnum");
            while(true) {
                guess.interrupt(); 		//唤醒猜数字线程
                guess.run();			//用run是要一直调用run()来随机生成随机数,然后和被猜测线程比较
                Thread.sleep(100);
                guessed.interrupt();  	//唤醒被猜测线程
                if(intnum.getRandomNum()==rannum.getRandomNum()) {
                    System.out.println("猜对啦!正确数字是:"+intnum.getRandomNum());
                    break;
                }	//if
                else if(intnum.getRandomNum()>rannum.getRandomNum())
                    System.out.println(intnum.getRandomNum()+"比正确数字大，猜大了。");
                else
                    System.out.println(intnum.getRandomNum()+"比正确数字小，猜小了。");
            }	//while
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class RandomNum implements Runnable{
    private int rnum;
    public synchronized void run() {
        Random num=new Random();
        rnum=num.nextInt(5090);

    }
    public int getRandomNum() {
        return rnum;
    }
    public void setRandomNum(int rnum) {
        this.rnum=rnum;
    }
}
