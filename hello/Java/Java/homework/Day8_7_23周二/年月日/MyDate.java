package Day8_7_23周二.年月日;

public class MyDate {
    private StringBuffer year = new StringBuffer("2011");
    private StringBuffer month = new StringBuffer("10");
    private StringBuffer day = new StringBuffer("17");

    public MyDate(StringBuffer year, StringBuffer month, StringBuffer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public StringBuffer getYear() {
        return year;
    }

    public StringBuffer getMonth() {
        return month;
    }

    public StringBuffer getDay() {
        return day;
    }

    public MyDate() {

    }

    public String toString() {
        return year+"-"+ month+"-"+ day;
    }
}
