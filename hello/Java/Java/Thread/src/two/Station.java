package two;

public class Station {
    private int tick = 5;



    public synchronized void sell(){
        if (tick>0){
            tick--;
            System.out.println(Thread.currentThread().getName()+"成功出售一张车票，剩余： "+ tick);
        }
    }
}
