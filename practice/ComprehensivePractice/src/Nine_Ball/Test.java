package Nine_Ball;

public class Test {
    public static void main(String[] args) {
        double height=100;
        double sum = 100;
        for (int i =0; i<=9;i++){
            sum+=height;
            height/=2;
        }
        System.out.println("第十次落地经过："+sum+"米");
        System.out.println("第十次反弹的高度: "+height/2);
    }
}
