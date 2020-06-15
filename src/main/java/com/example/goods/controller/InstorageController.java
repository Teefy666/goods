package com.example.goods.controller;

import com.example.goods.service.InstorageService;
import com.example.goods.utils.*;
import com.example.goods.vo.Instorage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Administrator
 * @date 2020/6/12
 */
@RequestMapping("/in")
@RestController
public class InstorageController {

    @Resource
    private InstorageService instorageServiceImpl;

    /**
     * 获取入库信息
     * @param msg type，联系人 json对象
     * @return 入库信息
     */
    @PostMapping("/getInstorageInfo/{msg}")
    public Result getInstorageInfo(@PathVariable("msg") String msg) {
        HashMap map = JsonUtils.stringToObj(msg, HashMap.class);
        String typeStr = null;
        try {
            typeStr = (String) map.get("type");
        } catch (Exception e) {
            return Result.error("类型不能为空！");
        }

        Integer type = Integer.parseInt(typeStr);
        String linkman = (String) map.get("linkman");

        Instorage instorage = instorageServiceImpl.selInstorageInfo(type, linkman);

        return Result.ok().put("instorage", instorage);
    }

    /**
     * 添加入库信息
     * @param msg 入库信息json对象
     * @return 是否成功
     */
    @PostMapping("/addInstorageInfo/{msg}")
    public Result addInstorageInfo(@PathVariable("msg") String msg) {

        Assert.isBlank(msg, "参数不能为空！");
        com.example.goods.entity.Instorage instorage = JsonUtils.stringToObj(msg, com.example.goods.entity.Instorage.class);
        Assert.isNull(instorage, "参数格式异常");

        Assert.isBlank(instorage.getCompany(), "单位不能为空");
        Assert.isBlank(instorage.getDepartment(), "部门不能为空");
        Assert.isBlank(instorage.getPhone(), "手机号不能为空");
        Assert.isNull(instorage.getIntime(), "入库时间不能为空");
        Assert.isNull(instorage.getType(), "入库类型不能为空");
        Assert.isBlank(instorage.getLinkman(), "联系人不能为空");
        Assert.isNull(instorage.getGoodsids(), "物资不能为空");
        Assert.isNull(instorage.getAmount(), "物资数量不能为空");
        //生成编码
        instorage.setCode(CodeUtil.getInstorageCode());
        try {
            instorageServiceImpl.insInstorageInfo(instorage);
        } catch (Exception e) {
            return Result.ok("发生未知错误！");
        }
        return Result.ok();
    }
}