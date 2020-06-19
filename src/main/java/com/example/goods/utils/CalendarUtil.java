package com.example.goods.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @author Administrator
 * @date 2020/6/19
 */
public class CalendarUtil {
    public static Date getDate() {
        //日历类的实例化
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        //设置日历时间
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        // 从一个 Calendar对象中获取 Date对象
        return calendar.getTime();
    }
}