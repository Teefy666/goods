package com.example.goods.controller;

import com.example.goods.entity.Inventory;
import com.example.goods.service.InventoryService;
import com.example.goods.utils.Assert;
import com.example.goods.utils.JsonUtils;
import com.example.goods.utils.RRException;
import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
     * 查询库存信息
     * @param msg 库存id，name
     * @return 库存信息
     */
    @PostMapping("/getInventory/{msg}")
    public Result getInventory(@PathVariable("msg") String msg) {
        HashMap map = JsonUtils.stringToObj(msg, HashMap.class);
        String idStr = null;
        try {
            idStr = (String) map.get("id");
        } catch (Exception e) {
            throw new RRException("类型id不能为空！");
        }

        Integer id = Integer.parseInt(idStr);
        String name = (String) map.get("name");

        List<HashMap<String, String>> lists = inventoryServiceImpl.selInventory(id, name);
        return Result.ok().put("lists", lists);
    }
}