package com.example.goods.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Administrator
 * @date 2020/6/19
 */
public class CalendarUtil {
    public static Date getDate() {
        //日历类的实例化
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        //设置日历时间，月份必须减一
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        // 从一个 Calendar对象中获取 Date对象
        return calendar.getTime();
    }
}