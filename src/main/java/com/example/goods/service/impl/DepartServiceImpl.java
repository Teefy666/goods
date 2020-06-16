package com.example.goods.service.impl;

import com.example.goods.entity.Company;
import com.example.goods.mapper.DepartMapper;
import com.example.goods.mapper.UserMapper;
import com.example.goods.service.DepartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 对部门信息操作类
 */
@Service
public class DepartServiceImpl implements DepartService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private DepartMapper departMapper;

    /**
     * 1、传入部门id 查询所属单位信息 返回JSON对象（接口：）e
     *
     * @param deptid
     * @return
     */
    @Override
    public Company queryDeptCompany(String deptid) {
        Company res=departMapper.queryCompanyById(deptid);
        return res;
    }

    /**
     * 2.传入部门id 删除该部门（如果该部门下还有员工 拒绝删除） 返回true或者false字符串（接口：）f
     *
     * @param deptid
     * @return
     */
    @Override
    public Boolean deleteDept(String deptid) {
        Integer num= userMapper.hasUsersInDept(deptid);
        if(num>0){
            return false;
        }else {
            departMapper.deleteDepartById(deptid);
            return true;
        }
    }
}
