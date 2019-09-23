package Day8_7_23周二.年月日;

public class MyDate3 {
    private int year;
    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    /**
     * 设置日期
     * year
     * month
     * day
     */
    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * 打印日期
     */
    public void printDate() {
        System.out.println("获取年份：" + this.getYear());
        System.out.println("获取月份：" + this.getMonth());
        System.out.println("获取日：" + this.getDay());
        System.out.println("输出的日期为：" + this.getYear() + "年" + this.getMonth() + "月" + this.getDay() + "日");
    }

    /**
     * 判断是否为闰年
     *  能被4整除，但是不能被100整除的的为闰年
     *  能被100整除，同时能被400整除的为闰年
     */
    public boolean isLeapYear() {
        if (this.getYear() % 4 == 0 && this.getYear() % 100 != 0) {
            return true;
        }
        if (this.getYear() % 100 == 0 && this.getYear() % 400 == 0) {
            return true;
        }
        return false;
    }
}

