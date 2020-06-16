package com.example.goods.service;

import com.example.goods.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/12
 */
public interface TypeService {

    /**
     * 查询全部类型
     * @return 全部类型
     */
    List<HashMap<String, String>> selAll();

    /**
     * 修改type
     * @param type type对象
     * @return 是否成功
     */
    Integer updType(Type type);

    /**
     * 添加type
     * @param name type name
     * @return 是否成功
     */
    Integer insType(String name);

    /**
     * 删除type
     * @param id type id
     * @return 是否成功
     */
    Integer delType(Integer id);
}