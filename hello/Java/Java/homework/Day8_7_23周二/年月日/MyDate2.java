package Day8_7_23周二.年月日;

public class MyDate2 {
    private int year = 2000;
    private int month = 01;
    private int day = 01;

    public MyDate2(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public MyDate2() {

    }
    public void ShowData2() {
        System.out.println(year+ "-" +0+ month + "-" +0+ day );
    }
}
