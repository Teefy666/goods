package com.example.goods.service.impl;

import com.example.goods.entity.Department;
import com.example.goods.mapper.CompanyMapper;
import com.example.goods.mapper.DepartMapper;
import com.example.goods.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private DepartMapper departMapper;
    @Resource
    private CompanyMapper companyMapper;
    /*
     * 1.传入单位id 查询所有的下属部门信息 返回list的json对象（接口：）g
     *
     * @param companyid
     * @return
     */
    @Override
    public List<Department> queryAllDeptsById(String companyid) {
        return departMapper.queryDeptsByCId(companyid);
    }

    /**
     * 2.传入单位id 删除该单位（如果该单位下还有部门 拒绝删除） 返回true或者false字符串（接口：）h
     *
     * @param companyid
     * @return
     */
    @Override
    public Boolean deleteCompany(String companyid) {
        Integer num=departMapper.hasDeptsInCompany(companyid);
        if (num==0){
            companyMapper.deleCompanyByCid(companyid);
            return true;
        }else {
            return false;
        }
    }
}
