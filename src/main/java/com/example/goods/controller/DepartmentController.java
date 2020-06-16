package com.example.goods.controller;

import com.example.goods.entity.Company;
import com.example.goods.service.DepartService;
import com.example.goods.utils.JsonUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DepartmentController {
    @Resource
    private DepartService departService;

    /**
     * 1.传入部门id 查询所属单位信息 返回JSON对象（接口：）e
     * @param msg
     * @return
     */
    @RequestMapping("/dept/queryDeptCompany/{msg}")
    public String queryDeptCompany(@PathVariable("msg") String msg) {
        Company company=departService.queryDeptCompany(msg);
        return JsonUtils.objToString(company);
    }

    /**
     * 2、传入部门id 删除该部门（如果该部门下还有员工 拒绝删除） 返回true或者false字符串（接口：）f
     * @param msg
     * @return
     */
    @RequestMapping("/dept/deleteDept/{msg}")
    public String deleteDept(@PathVariable("msg") String msg) {
        Boolean flag=departService.deleteDept(msg);
       if (flag){
           return "true";
       }else {
           return "false";
       }
    }

}
