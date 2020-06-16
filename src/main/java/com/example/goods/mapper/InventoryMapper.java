package com.example.goods.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/13
 */
@Mapper
public interface InventoryMapper {
    /**
     * 根据类型id查询库存
     * @param id 类型id
     * @param name 物资名
     * @return 库存信息
     */
    List<HashMap<String, String>> selInventory(@Param("id") Integer id, @Param("name") String name);

    /**
     * 查询库存数量，入库出库用
     * @param id 库存id
     * @return 库存数量
     */
    Integer selCounts(@Param("id") Integer id);

    /**
     * 添加物资资料的时候同时添加库存信息
     * @param id 物资资料id
     * @return 是否成功
     */
    Integer insInventory(@Param("id")Integer id);

    /**
     * 删除物资资料的时候同时删除库存信息
     * @param id 物资资料id
     * @return 是否成功
     */
    Integer delInventory(@Param("id")Integer id);

    /**
     * 修改数量
     * @param id 物资id
     * @param amount 数量
     * @return 是否成功
     */
    Integer updAmounts(@Param("id")Integer id, @Param("amount") Integer amount);
}