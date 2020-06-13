package com.example.goods.service;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/13
 */
public interface InventoryService {
    /**
     * 根据类型id查询库存
     * @param id 类型id
     * @param name 物资名
     * @return 库存信息
     */
    List<HashMap<String, String>> selInventory(Integer id, String name);
}