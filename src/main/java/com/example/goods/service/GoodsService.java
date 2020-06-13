package com.example.goods.service;

import com.example.goods.entity.Goods;
import com.example.goods.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/12
 */
public interface GoodsService {

    /**
     * 根据类型id查询物资资料
     * @param id 类型id
     * @param name 物资名
     * @return 物资资料
     */
    List<HashMap<String, String>> selGoods(Integer id, String name);

    /**
     * 删除物资资料
     * @param id 资料id
     * @return 是否成功
     */
    Integer delGoods(Integer id);

    /**
     * 添加物资资料
     * @param goods 资料对象
     * @return 是否成功
     */
    Integer insGoods(Goods goods);

    /**
     * 修改物资资料
     * @param goods 资料对象
     * @return 是否成功
     */
    Integer updGoods(Goods goods);
}