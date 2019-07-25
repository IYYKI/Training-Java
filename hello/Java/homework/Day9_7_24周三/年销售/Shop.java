package Day9_7_24周三.年销售;

public class Shop {
    private ComputeTotalSales[] totalSales;
    public Shop(ComputeTotalSales [] totalSales){
        this.totalSales = totalSales;
    }
    public double getTotalSalesByYear(){
        double sum = 0;
        for (int i = 0;i<totalSales.length;i++){
            sum+=totalSales[i].totalSalesByYear();
        }return sum;
    }
}
