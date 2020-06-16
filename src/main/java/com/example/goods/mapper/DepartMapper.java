package com.example.goods.mapper;

import com.example.goods.entity.Company;
import com.example.goods.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 部门表mapper类
 */
@Mapper
public interface DepartMapper {
    /**
     * 1.通过部门id，查询所属单位信息 e
     * @param id
     * @return
     */
    @Select("select * from company where company.id=(select companyid from department where id=#{id})")
    Company queryCompanyById(@Param("id") String id);

    /**
     * 2.通过部门id,删除部门 f2
     * @param id
     * @return
     */
    @Delete("delete from department where department.id=#{id}")
    Integer deleteDepartById(@Param("id") String id);

    /**
     * 3.传入单位id 查询所有的下属部门信息 返回list的json对象（接口：）g
     * @param companyid
     * @return
     */
    @Select("select * from department where department.companyid=#{companyid}")
    List<Department> queryDeptsByCId(@Param("companyid") String companyid);

    /**
     * 4.查询指定单位id下的部门数量 h2
     * @param companyid
     * @return
     */
    @Select("select count(*) from department where department.companyid=#{companyid}")
    Integer hasDeptsInCompany(@Param("companyid") String companyid);

}

