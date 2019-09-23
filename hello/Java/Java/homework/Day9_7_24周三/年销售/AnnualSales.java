package Day9_7_24周三.年销售;

public class AnnualSales {
    public static void main(String[] args) {
        Computer computer = new Computer(1000);
        Mobile mobile = new Mobile(2000);
        Television t = new Television(3000);
        ComputeTotalSales [] computeTotalSales = new ComputeTotalSales[]{computer,mobile,t};
        Shop s = new Shop(computeTotalSales);
        System.out.println(s.getTotalSalesByYear());
    }
}