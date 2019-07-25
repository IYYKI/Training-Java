package Day9_7_24周三.年销售;

public class Television implements ComputeTotalSales {
    private double sell;
    public Television (double sell){
        this.sell = sell;
    }
    public double totalSalesByYear() {
        return sell;
    }


}
