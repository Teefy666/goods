package com.example.goods.service;

import com.example.goods.entity.Department;

import java.util.List;

/**
 * 对单位信息的操作
 */
public interface CompanyService {
    /**
     * 1.传入单位id 查询所有的下属部门信息 返回list的json对象（接口：）g
     * @param companyid
     * @return
     */
    List<Department> queryAllDeptsById(String companyid);

    /**
     * 2.传入单位id 删除该单位（如果该单位下还有部门 拒绝删除） 返回true或者false字符串（接口：）h
     * @param companyid
     * @return
     */
    Boolean deleteCompany(String companyid);
}
