package Day6_7_19周五.钱包;

public class WalletTest {
    public static void main (String [] args){
        Purse p1 = new Purse(500);
        Purse p2 = new Purse(1000);
        Swap s1 = new Swap();
        s1.exchange1(100,200);
        s1.exchange(p1,p2);
        s1.exchange2(p1,p2);
    }
}
