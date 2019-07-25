package Day8_7_23周二.年月日;

import java.text.*;
import java.util.*;


public class DateTest extends MyDate {
    public static void main(String[] args) {
        MyDate2 date = new MyDate2();
        date.ShowData2();
        Date dtN = new Date();
        MyDate d2 = new MyDate();
        System.out.println(d2.toString());
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(dt.format(dtN));

        System.out.println("-----------------");
        //1.初始化日期类对象
        MyDate3 dateUtil = new MyDate3();
        //2.调用日期设置方法设置日期
        dateUtil.setDate(2012, 9, 32);
        //3.打印设置的日期
        dateUtil.printDate();
        //4.判断上述设置的年份是否为闰年
        if (dateUtil.isLeapYear()) {
            System.out.println("上述设置的年份为 " + dateUtil.getYear() + "，该年份是闰年.");
        } else {
            System.out.println("上述设置的年份为 " + dateUtil.getYear() + "，该年份不是闰年.");
        }
    }
}

