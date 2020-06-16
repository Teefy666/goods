package com.example.goods.service.impl;

import com.example.goods.entity.User;
import com.example.goods.mapper.LoginMapper;
import com.example.goods.mapper.UserMapper;
import com.example.goods.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public  class LoginServiceImpl implements LoginService {
    @Resource
    private LoginMapper loginMapper;
    @Resource
    private UserMapper userMapper;


    /**
     * 3.手机号一键登录
     * roleid=1;departmentid=1,设为默认组
     * 功能c
     * @param phone
     * @return
     */
    @Override
    public User login_Directly_Service(String phone) {
        if(phone==null||phone.trim().isEmpty()){
            return null;
        }
        User res=userMapper.queryUserByPhone(phone);
        if (res!=null){
            return res;
       }else{
            User defalutUser=new User(phone,"游客",null,null,null,1,1);
            userMapper.insertUser(defalutUser);
            return defalutUser;
        }
    }

}
