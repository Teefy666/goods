package com.example.goods.utils;

import java.util.Date;

/**
 * @author Administrator
 * @date 2020/6/14
 */
public class CodeUtil {
    public static String getGoodsCode() {
        return "" + System.currentTimeMillis();
    }

    public static String getInstorageCode() {
        return "R" + System.currentTimeMillis();
    }

    public static String getOutstorageCode() {
        return "C" + System.currentTimeMillis();
    }
}