package com.example.goods.controller;

import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @date 2020/6/11
 */
@RequestMapping("/goods")
@RestController
public class GoodsController {

    @RequestMapping("/addGoods")
    public Result addGoods() {

        return Result.ok();
    }

    @RequestMapping("/getGoods")
    public Result getGoods() {

        return Result.ok();
    }

    @RequestMapping("/updGoods")
    public Result updGoods() {

        return Result.ok();
    }

    @RequestMapping("/delGoods")
    public Result delGoods() {

        return Result.ok();
    }
}