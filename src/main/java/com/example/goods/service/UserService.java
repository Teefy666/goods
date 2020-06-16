package com.example.goods.service;

import com.example.goods.entity.Department;
import com.example.goods.entity.User;

/**
 * 对于用户的操作类
 */
public interface UserService {
    /**
     *
     *1. 传入手机号 删除该用户 返回true或者false字符串 a
     * @param phone
     * @return
     */
    Boolean deleteUser(String phone);

    /**
     * 2.传入用户json数据 更新用户信息 除了手机号 其他信息全部更新 返回true或者false字符串（接口：）b
     * @param userUpdated
     * @return
     */
    Boolean updateUserInfo(User userUpdated);

    /**
     * 3.传入手机号 查询用户的部门信息 返回JSON对象（接口：）d
     * @param phone
     * @return
     */
    Department queryUserDept(String phone);
}
