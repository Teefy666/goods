package com.example.goods.service.impl;

import com.example.goods.entity.Department;
import com.example.goods.entity.User;
import com.example.goods.mapper.UserMapper;
import com.example.goods.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    /**
     * 1. 传入手机号 删除该用户 返回true或者false字符串 a
     * @param phone
     * @return
     */
    @Override
    public Boolean deleteUser(String phone) {
        if(phone==null||phone.trim().isEmpty()){
            return false;
        }
        Integer tag=userMapper.deleUser(phone);
        if (tag!=0){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 2.传入用户json数据 更新用户信息 除了手机号 其他信息全部更新 返回true或者false字符串（接口：）b
     *
     * @param userUpdated
     * @return
     */
    @Override
    public Boolean updateUserInfo(User userUpdated) {
        try{
            Integer tag=userMapper.updateUser(userUpdated);
            if (tag!=0){
                return true;
            }else {
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("用户数据更新异常!");
            return false;
        }
    }

    /**
     * 3.传入手机号 查询用户的部门信息 返回JSON对象（接口：）d
     *
     * @param phone
     * @return
     */
    @Override
    public Department queryUserDept(String phone) {
        if(phone==null||phone.trim().isEmpty()){
            return new Department();
        }
        Department res=userMapper.queryDepartByPhone(phone);
        return res;
    }
}
