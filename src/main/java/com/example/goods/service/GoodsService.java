package com.example.goods.service;

import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Administrator
 * @date 2020/6/12
 */
public interface GoodsService {

    public Result addGoods();

    public Result getGoods();

    public Result updGoods();

    public Result delGoods();
}