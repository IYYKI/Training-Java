package Day6_7_19周五.电脑店;

public class Computer{
    private String ComputerName;
    private int  ComputerPrice;
    private String SequenceCode;

    public String getComputerName() {
        return ComputerName;
    }

    public int getComputerPrice() {
        return ComputerPrice;
    }

    public String getSequenceCode() {
        return SequenceCode;
    }

    public Computer(String ComputerName,int ComputerPrice,String SequenceCode){
        this.ComputerName = ComputerName;
        this.ComputerPrice = ComputerPrice;
        this.SequenceCode = SequenceCode;

    }
}

