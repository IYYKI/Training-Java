package FirstThread;

public class Test {
    public static void main (String [] args){
      Mythread m = new Mythread();
      Mysthead2 m2 = new Mysthead2();
      m.setName("小胖");
      m2.setName("小红");
      m.start();
      m2.start();
    }
}
class Mythread  extends Thread{

    @Override
    public void run() {
        for (int i = 1 ; i<=10 ; i++){
            System.out.println(Thread.currentThread().getName()+"-->"+i);
        }
    }
}
class Mysthead2 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->" + i);
        }
    }
}