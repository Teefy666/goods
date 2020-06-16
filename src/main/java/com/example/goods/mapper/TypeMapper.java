package com.example.goods.mapper;

import com.example.goods.entity.Type;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/12
 */
@Mapper
public interface TypeMapper {
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
    Integer updType(@Param("type") Type type);

    /**
     * 添加type
     * @param name type name
     * @return 是否成功
     */
    Integer insType(@Param("name") String name);

    /**
     * 删除type
     * @param id type id
     * @return 是否成功
     */
    Integer delType(@Param("id") Integer id);
}