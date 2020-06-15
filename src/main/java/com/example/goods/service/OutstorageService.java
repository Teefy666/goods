package com.example.goods.service;

import com.example.goods.entity.Outstorage;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @date 2020/6/14
 */
public interface OutstorageService {

    /**
     * 查询发放信息
     * @param type 发放类型
     * @param linkman 联系人
     * @return 发放信息
     */
    com.example.goods.vo.Outstorage selOutstorageInfo(Integer type, String linkman);

    /**
     * 添加发放信息
     * @param out 发放信息对象
     * @return 是否成功
     */
    Integer insOutstorageInfo(Outstorage out);

    /**
     * 添加用户申请发放信息
     * @param out 发放信息对象
     * @return 是否成功
     */
    Integer insUserApply(Outstorage out);

    /**
     * 通过申请
     * @param goodsid 物资id
     * @return 是否成功
     */
    Integer passUserApply(Integer goodsid);
}