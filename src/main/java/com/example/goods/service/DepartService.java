package com.example.goods.service;

import com.example.goods.entity.Company;

public interface DepartService {
    /**
     * 1、传入部门id 查询所属单位信息 返回JSON对象（接口：）e
     * @param deptid
     * @return
     */
    Company queryDeptCompany(String deptid);

    /**
     * 2.传入部门id 删除该部门（如果该部门下还有员工 拒绝删除） 返回true或者false字符串（接口：）f
     * @param deptid
     * @return
     */
    Boolean deleteDept(String deptid);
}
