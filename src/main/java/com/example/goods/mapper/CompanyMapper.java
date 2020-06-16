package com.example.goods.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 单位管理mapper类
 */
@Mapper
public interface CompanyMapper {
    /**
     * 1.传入单位id 删除该单位 h1
     * @param companyid
     * @return
     */
    @Delete("delete from company where company.id=#{id}")
    Integer deleCompanyByCid(@Param("id") String companyid);
}
