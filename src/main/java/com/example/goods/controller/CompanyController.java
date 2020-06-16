package com.example.goods.controller;

import com.example.goods.entity.Department;
import com.example.goods.service.CompanyService;
import com.example.goods.utils.JsonUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CompanyController {
    @Resource
    private CompanyService companyService;

    /**
     * 1.传入单位id 查询所有的下属部门信息 返回list的json对象（接口：）g
     * @param msg
     * @return
     */
    @RequestMapping("/company/queryCompanyDepts/{msg}")
    public String queryCompanyDepts(@PathVariable("msg") String msg) {
        List<Department> depts=companyService.queryAllDeptsById(msg);
        return JsonUtils.objToString(depts);
    }

    /**
     * 2.传入单位id 删除该单位（如果该单位下还有部门 拒绝删除） 返回true或者false字符串（接口：）h
     * @param msg
     * @return
     */
    @RequestMapping("/company/deleteCompany/{msg}")
    public String deleteCompany(@PathVariable("msg") String msg) {
        Boolean flag=companyService.deleteCompany(msg);
       if (flag){
           return "true";
       }else {
           return "false";
       }
    }


}
