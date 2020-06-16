package com.example.goods.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author QG
 */
public class JsonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转字符串
     */
    public static <T> String objToString(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 字符串转对象
     */
    public static <T> T stringToObj(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 将Json字符串转化为地址栏
     * @param jsonStr 待转换的Json字符串
     * @return 转化后的URL字符串
     * @throws UnsupportedEncodingException
     */
    public static String setJsonToUrl(String jsonStr) throws UnsupportedEncodingException {
        return URLEncoder.encode(jsonStr, "utf-8");
    }

    /**
     * 将从URL获取的值转化为Json字符串
     * @param jsonStr 从地址栏获取的值
     * @return 转化后的Json字符串
     * @throws UnsupportedEncodingException
     */
    public static String getJsonFromUrl(String jsonStr) throws UnsupportedEncodingException {
        return URLDecoder.decode(jsonStr, "utf-8");
    }
}
