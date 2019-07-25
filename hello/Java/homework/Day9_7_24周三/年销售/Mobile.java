package Day9_7_24周三.年销售;

public class Mobile implements ComputeTotalSales {
    private double sell;
    public Mobile (double sell){
        this.sell = sell;
    }
    public double totalSalesByYear() {
        return sell;
    }

}
