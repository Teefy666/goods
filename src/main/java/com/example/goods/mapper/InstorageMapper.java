package com.example.goods.mapper;

import com.example.goods.entity.Instorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/14
 */
@Mapper
public interface InstorageMapper {
    /**
     * 查询入库信息
     * @param type 入库类型
     * @param linkman 联系人
     * @return 入库信息
     */
    Instorage selInstorageInfo(@Param("type") Integer type, @Param("linkman") String linkman);

    /**
     * 查询入库信息附带的物资信息
     * @param goodsidsList 物资ids
     * @return 物资信息
     */
    List<HashMap<String, Object>> selGoodsInfos(@Param("goodsidsList") List<Integer> goodsidsList);

    /**
     * 添加入库信息
     * @param in 入库信息对象
     * @return 是否成功
     */
    Integer insInstorageInfo(@Param("in") Instorage in);

    /**
     * 添加入库信息后更新库存数量
     * @param goodsid 物资id
     * @param amount 物资数量
     * @return 是否成功
     */
    Integer updAmount(@Param("goodsid") Integer goodsid, @Param("amount") Integer amount);
}