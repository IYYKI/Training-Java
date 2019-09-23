package ClassWorks.Servlet.Day_8_29_WorkOne.Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LifeUtil {

    public static int life(String birthday) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bir = null;
        try {
            bir = sdf.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date now = new Date();
        long timeBir = bir.getTime();
        long timeNow = now.getTime();
        long time = timeNow-timeBir;
        return (int)(time/1000/60/60/24);
    }
}