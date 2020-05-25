package com.example.goods.utils;

import com.example.goods.utils.Page;

/**
 * 分页工具类
 * @author TongTianFu
 * @date 2020/5/25
 */
public class PageUtil {
    /**
     * 创建并初始化一个page
     * @param pageNum 当前页数
     * @param pageSize 页面大小
     * @return
     */
    public static Page newPage(Integer pageNum, Integer pageSize){
        if(pageNum == null){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 10;
        }
        Page page = new Page();
        page.setPs(pageSize);
        page.setPn(pageNum);
        return page;
    }

    /**
     * 计算当前页面开始index
     * @param pageNum 当前页数
     * @param pageSize 页面大小
     * @return
     */
    public static int getPageStart(int pageNum, int pageSize){
        return (pageNum - 1) * pageSize;
    }

    /**
     * 计算总页数
     * @param total 总条目
     * @param pageSize 页面大小
     * @return
     */
    public static int getTotal(int total, int pageSize){
        return (int)Math.ceil(total*1.0/pageSize);
    }
}