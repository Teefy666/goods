package com.example.goods.controller;

import com.example.goods.service.InventoryService;
import com.example.goods.utils.Assert;
import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/13
 */
@RequestMapping("/Inventory")
@RestController
public class InventoryController {

    @Resource
    private InventoryService inventoryServiceImpl;

    /**
     * 查询库存
     * @param id 类型id
     * @param name 物资名
     * @return 库存信息
     */
    @RequestMapping("/getInventory")
    public Result getInventory(Integer id, String name) {
        Assert.isNull(id, "类型id不能为空！");

        List<HashMap<String, String>> lists = inventoryServiceImpl.selInventory(id, name);
        return Result.ok().put("lists", lists);
    }
}