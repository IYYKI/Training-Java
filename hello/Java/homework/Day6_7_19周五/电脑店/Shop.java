package Day6_7_19周五.电脑店;


public class Shop {
    private final int Number = 60;
    private Computer [] computers;
    public Shop(){
        computers = new Computer[Number];
        for (int i = 0; i<computers.length;i++){
            computers [i] = new Computer("华硕电脑",5999,"序列号: "+"FVFXL0WRHV2F");
        }
    }
    public void computerxx(int index){
        if(index < 0 || index > computers.length){
            System.out.println("不得行，找不到,超了别闹");
        }else {
            System.out.println("电脑品牌: "+computers[index].getComputerName());
            System.out.println("电脑价格: "+computers[index].getComputerPrice()+"元");
            System.out.println(computers[index].getSequenceCode());
        }
    }
}