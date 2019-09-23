package HomeWork.HW2;

public class Makeup implements Runnable{
    static private Lipstick lipstick=new Lipstick();    //口红
    static private Mirror mirror=new Mirror();  //镜子
    private int choice; //0代表先拿口红,1代表先拿镜子mm
    private String name;

    public Makeup(int choice,String name) {
        this.choice = choice;
        this.name=name;
    }

    @Override
    public void run() {
        makeup();
    }
    public void makeup(){
        if(choice==0){
            synchronized (lipstick){
                System.out.println(name+"涂口红");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (mirror){
                    System.out.println(name+"照镜子");
                }
            }
        }else{
            synchronized (mirror){
                System.out.println(name+"照镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lipstick){
                    System.out.println(name+"涂口红");
                }
            }
        }
    }
}
/**
 *
 * if(choice==0){
 *             synchronized (lipstick){
 *                 System.out.println(name+"涂口红");
 *                 try {
 *                     Thread.sleep(1000);
 *                 } catch (InterruptedException e) {
 *                     e.printStackTrace();
 *                 }
 *             }
 *             synchronized (mirror){
 *                 System.out.println(name+"照镜子");
 *             }
 *         }
 *
 * **/