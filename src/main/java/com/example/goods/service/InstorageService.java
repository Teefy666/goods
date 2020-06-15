package com.example.goods.service;

import com.example.goods.vo.Instorage;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @date 2020/6/14
 */
public interface InstorageService {
    /**
     * 查询入库信息
     * @param type 入库类型
     * @param linkman 联系人
     * @return 入库信息
     */
    Instorage selInstorageInfo(Integer type, String linkman);

    /**
     * 添加入库信息
     * @param in 入库信息对象
     * @return 是否成功
     */
    Integer insInstorageInfo(com.example.goods.entity.Instorage in);
}