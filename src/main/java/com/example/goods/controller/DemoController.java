package com.example.goods.controller;

import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TongTianFu
 * @date 2020/5/25
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/demo")
    public Result demo() {
        return Result.ok("ninghao");
    }
}