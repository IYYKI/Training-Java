package Day8_7_23周二.电器共通性;

public class Test{
    public static void main (String [] args) {
        Tv t =new Tv();
        phone p = new phone();
        System.out.println("电视：");
        t.Cans();
        System.out.println();
        System.out.println("手机： ");
        p.TellPhone();
        p.Cans();
    }
}
