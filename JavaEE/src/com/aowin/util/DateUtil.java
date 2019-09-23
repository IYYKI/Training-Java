package com.aowin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getDate() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd ");
        return ft.format(dNow);
    }

}
