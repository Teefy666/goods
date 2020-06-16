package com.example.goods.controller;

import com.example.goods.entity.Department;
import com.example.goods.entity.User;
import com.example.goods.service.UserService;
import com.example.goods.utils.JsonUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 1.传入手机号 删除该用户 返回true或者false字符串
     * @param msg
     * @return
     */
    @RequestMapping("/user/delete/{msg}")
    public String deleteUser(@PathVariable("msg") String msg) {
        Boolean flag=userService.deleteUser(msg);
        if (flag){
            return "true";
        }else {
            return "false";
        }

    }

    /**
     * 2.传入用户json数据 更新用户信息 除了手机号 其他信息全部更新 返回true或者false字符串（接口：）b
     * @param msg
     * @return
     */
    @RequestMapping("/user/update/{msg}")
    public String updateUser(@PathVariable("msg") String msg) {
        User userUpdated=JsonUtils.stringToObj(msg, User.class);
        Boolean flag=userService.updateUserInfo(userUpdated);
        if (flag){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 3.传入手机号 查询用户的部门信息 返回JSON对象（接口：）（）d
     * @param msg
     * @return
     */
    @RequestMapping("/user/queryDepts/{msg}")
    public String queryDepts(@PathVariable("msg") String msg) {
        Department dept=userService.queryUserDept(msg);
        return JsonUtils.objToString(dept);
    }

}
