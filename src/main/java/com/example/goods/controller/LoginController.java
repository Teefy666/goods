package com.example.goods.controller;

import com.example.goods.entity.User;
import com.example.goods.service.LoginService;
import com.example.goods.utils.JsonUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 1.登录 c
     * @param msg
     * @param session
     * @return
     */
    @RequestMapping("/login/{msg}")
    public String do_login(@PathVariable("msg") String msg,HttpSession session) {
        User user = loginService.login_Directly_Service(msg);
        //查询登录用户的个人信息
        session.setAttribute("phone", msg);
        session.setMaxInactiveInterval(60 * 60 * 3);//3小时
        return JsonUtils.objToString(user);
    }

    /**
     * 2.注销
     * @param session
     */
    @RequestMapping("/logout")
    public void do_logout(HttpSession session) {
        session.removeAttribute("phone");
    }

}
