package com.example.goods.mapper;

import com.example.goods.entity.Department;
import com.example.goods.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * user表Mapper类
 */
@Mapper
public interface UserMapper {
    /**
     *1.通过手机号删除用户 a
     */
    @Delete("delete from user where user.phone=#{phone}")
    Integer deleUser(@Param("phone") String phone);
    /**
     *2.更新用户信息 b
     */
    @Update("update user set phone=#{user.phone}," +
            "name=#{user.name},age=#{user.age}," +
            "gender=#{user.gender},remark=#{user.remark}," +
            "departmentid=#{user.departmentid},roleid=#{user.roleid} where phone=#{user.phone} ")
    Integer updateUser(@Param("user") User user);

    /**
     * 3.传入手机号，判断用户是否存在 c1
     * @param phone
     * @return
     */
    @Select("select count(*) from user where phone=#{phone}")
    Integer isExistedByPhone(@Param("phone") String phone);

    /**
     * 3.1 根据手机号查询指定用户
     * @param phone
     * @return
     */
    @Select("select * from user where phone=#{phone}")
    User queryUserByPhone(@Param("phone") String phone);

    /**
     * 4.创建用户信息
     * @param user c2
     * @return
     */
    @Insert("Insert into user(phone,name,age,gender,remark,departmentid,roleid)" +
            " values (#{user.phone},#{user.name},#{user.age},#{user.gender}," +
            "#{user.remark},#{user.departmentid},#{user.roleid})")
    Integer insertUser(@Param("user") User user);

    /**
     * 5.查询指定手机号用户的所属部门信息 d
     * @param phone
     * @return
     */
    @Select("select * from department where department.id=(select departmentid from user where phone=#{phone})")
    Department queryDepartByPhone(@Param("phone") String phone);

    /**
     * 6.查询指定部门id下的部门所辖员工数量 f1
     * @param deptid
     * @return
     */
    @Select("select count(*) from user where departmentid=#{departmentid}")
    Integer hasUsersInDept(@Param("departmentid") String deptid);
}
