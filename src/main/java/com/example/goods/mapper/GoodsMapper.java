package com.example.goods.mapper;

import com.example.goods.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/12
 */
@Mapper
public interface GoodsMapper {
    /**
     * 根据类型id查询物资资料
     * @param id 类型id
     * @param name 物资名
     * @return 物资资料
     */
    List<HashMap<String, String>> selGoods(@Param("id") Integer id, @Param("name") String name);

    /**
     * 删除物资资料
     * @param id 资料id
     * @return 是否成功
     */
    Integer delGoods(@Param("id") Integer id);

    /**
     * 添加物资资料
     * @param goods 资料对象
     * @return 资料id
     */
    Integer insGoods(@Param("goods") Goods goods);

    /**
     * 修改物资资料
     * @param goods 资料对象
     * @return 是否成功
     */
    Integer updGoods(@Param("goods") Goods goods);
}