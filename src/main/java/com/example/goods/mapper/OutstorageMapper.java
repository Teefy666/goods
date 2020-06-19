package com.example.goods.mapper;

import com.example.goods.entity.Outstorage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/14
 */
@Mapper
public interface OutstorageMapper {

    /**
     * 查询发放信息
     * @param type 发放类型
     * @param linkman 联系人
     * @return 发放信息
     */
    List<com.example.goods.vo.Outstorage> selOutstorageInfo(@Param("type") Integer type, @Param("linkman") String linkman);

    /**
     * 查询对应的物资信息
     * @param goodsidsList 物资ids
     * @return 物资信息
     */
    List<HashMap<String, Object>> selGoodsInfos(@Param("goodsidsList") List<Integer> goodsidsList);

    /**
     * 添加发放信息
     * @param out 发放信息对象
     * @return 是否成功
     */
    Integer insOutstorageInfo(@Param("out") Outstorage out);

    /**
     * 添加发放信息后，修正数量
     * @param goodsid 物资id
     * @param amount 物资数量
     * @return 是否成功
     */
    Integer updAmount(@Param("goodsid") Integer goodsid, @Param("amount") Integer amount);

    /**
     * 查询对应物资数量，用于检测是否足够
     * @param goodsidsList 物资ids
     * @return 物资数量
     */
    List<Integer> selGoodsAmount(@Param("goodsidsList") List<Integer> goodsidsList);

    /**
     * 根据发放id查询发放信息
     * @param id 发放id
     * @return 发放信息
     */
    Outstorage selOutstorageByid(@Param("id") Integer id);

    /**
     * 修改发放信息
     * @param out 待修改的发放信息
     * @return 是否成功
     */
    Integer updOutstorageInfo(@Param("out") Outstorage out);

    /**
     * 删除发放信息
     * @param id 发放id
     * @return 是否成功
     */
    Integer delOutstorageInfo(@Param("id") Integer id);
}