package com.example.goods.utils;

import java.util.List;

/**
 * 分页类
 * @author TongTianFu
 * @date 2020/5/25
 */
public class Page {

    private Integer pn;
    private Integer ps;
    private Integer total;
    private List<?> list;

    public Page(){}

    public Integer getPn() {
        return pn;
    }

    public void setPn(Integer pn) {
        this.pn = pn;
    }

    public Integer getPs() {
        return ps;
    }

    public void setPs(Integer ps) {
        this.ps = ps;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
