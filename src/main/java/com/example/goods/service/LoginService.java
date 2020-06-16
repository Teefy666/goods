package com.example.goods.service;

import com.example.goods.entity.User;

/**
 * 用户登录注册
 */
public interface LoginService {

     /**
      * 3.手机号一键登录 功能c
      * roleid=1;departmentid=1,设为默认组
      * @param phone
      * @return
      */
     User login_Directly_Service(String phone);
}
