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
     * @return 库存信息
     */
    List<HashMap<String, String>> selInventoryByTypeId(@Param("id") Integer id);
}