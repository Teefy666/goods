package com.example.goods.utils;

import com.example.goods.utils.RRException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author TongTianFu
 * @date 5/25
 */
public class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object obj, String message) {
        if (obj == null) {
            throw new RRException(message);
        }
    }

    public static void isNotNull(Object object, String message) {
        if (object != null) {
            throw new RRException(message);
        }
    }

    public static void isNullList(List list, String message){
        if (list == null || list.size() == 0) {
            throw new RRException(message);
        }
    }

    public static void isCorrectList(List<Integer> list) {
        if(list.size()==0){
            throw new RRException("list长度不能为0");
        }
    }
}
