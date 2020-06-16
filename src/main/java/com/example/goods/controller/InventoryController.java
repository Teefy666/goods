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

/**i
 * @author Administrator
 * @date 2020/6/13
 */
@RequestMapping("/inventory")
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
        Integer id = null;
        try {
            idStr = (String) map.get("id");
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
            Result.error("类型id不能为空！");
        }

        String name = (String) map.get("name");
        List<HashMap<String, String>> lists = inventoryServiceImpl.selInventory(id, name);
        return Result.ok().put("lists", lists);
    }

    /**
     * 修改库存数量
     * @param msg 物资id，数量
     * @return 库存信息
     */
    public Result updAmount(@PathVariable("msg") String msg) {
        HashMap map = JsonUtils.stringToObj(msg, HashMap.class);
        String idStr = null;
        String amountStr = null;
        Integer id = null;
        Integer amount = null;
        try {
            idStr = (String) map.get("id");
            amountStr = (String) map.get("amount");

            id = Integer.parseInt(idStr);
            amount = Integer.parseInt(amountStr);
        } catch (Exception e) {
            Result.error("类型id不能为空！");
        }

        try {
            inventoryServiceImpl.updAmounts(id, amount);
        } catch (Exception e) {
            Result.error("发生未知错误！");
        }
        return Result.ok();
    }
}