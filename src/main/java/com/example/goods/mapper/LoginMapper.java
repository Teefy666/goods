package com.example.goods.mapper;

import com.example.goods.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 登录注册Mapper类
 */
@Mapper
public interface LoginMapper {
    /**
     * 1.登录:
     * @param phone
     * @return
     */
   @Select("select count(*) from user where phone=#{phone}")
    Integer isExisted(@Param("phone") String phone);

    /**
     * 2.注册
     * @param user
     * @return
     */
   @Insert("Insert into user(phone,name,age,gender,remark,departmentid,roleid) values (#{user.phone},#{user.name},#{user.age},#{user.gender},#{user.remark},#{user.departmentid},#{user.roleid})")
   Integer insertUser(@Param("user") User user);
}
