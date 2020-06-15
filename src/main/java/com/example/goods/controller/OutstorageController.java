package com.example.goods.controller;

import com.example.goods.service.InstorageService;
import com.example.goods.service.OutstorageService;
import com.example.goods.utils.Assert;
import com.example.goods.utils.CodeUtil;
import com.example.goods.utils.JsonUtils;
import com.example.goods.utils.Result;
import com.example.goods.vo.Instorage;
import com.example.goods.vo.Outstorage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author Administrator
 * @date 2020/6/12
 */
@RequestMapping("/out")
@RestController
public class OutstorageController {

    @Resource
    private OutstorageService outstorageServiceImpl;

    /**
     * 获取发放信息
     * @param msg type，联系人 json对象
     * @return 发放信息
     */
    @PostMapping("/getOutstorageInfo/{msg}")
    public Result getOutstorageInfo(@PathVariable("msg") String msg) {
        HashMap map = JsonUtils.stringToObj(msg, HashMap.class);
        String typeStr = null;
        try {
            typeStr = (String) map.get("type");
        } catch (Exception e) {
            return Result.error("类型不能为空！");
        }

        Integer type = Integer.parseInt(typeStr);
        String linkman = (String) map.get("linkman");

        Outstorage outstorage = outstorageServiceImpl.selOutstorageInfo(type, linkman);

        return Result.ok().put("outstorage", outstorage);
    }

    /**
     * 添加发放信息
     * @param msg 入库信息json对象
     * @return 是否成功
     */
    @PostMapping("/addOutstorageInfo/{msg}")
    public Result addOutstorageInfo(@PathVariable("msg") String msg) {

        Assert.isBlank(msg, "参数不能为空！");
        com.example.goods.entity.Outstorage outstorage = JsonUtils.stringToObj(msg, com.example.goods.entity.Outstorage.class);
        Assert.isNull(outstorage, "参数格式异常");

        Assert.isBlank(outstorage.getCompany(), "单位不能为空");
        Assert.isBlank(outstorage.getDepartment(), "部门不能为空");
        Assert.isBlank(outstorage.getPhone(), "手机号不能为空");
        Assert.isNull(outstorage.getIntime(), "入库时间不能为空");
        Assert.isNull(outstorage.getType(), "入库类型不能为空");
        Assert.isBlank(outstorage.getLinkman(), "联系人不能为空");
        Assert.isNull(outstorage.getGoodsids(), "物资不能为空");
        Assert.isNull(outstorage.getAmount(), "物资数量不能为空");

        outstorage.setCode(CodeUtil.getOutstorageCode());
        try {
            outstorageServiceImpl.insOutstorageInfo(outstorage);
        } catch (Exception e) {
            return Result.ok("发生未知错误！");
        }
        return Result.ok();
    }

    /**
     * 提交用户申请发放
     * @param msg 入库信息json对象
     * @return 是否成功
     */
    @PostMapping("/addUserApply/{msg}")
    public Result addUserApply(@PathVariable("msg") String msg) {
        Assert.isBlank(msg, "参数不能为空！");
        com.example.goods.entity.Outstorage outstorage = JsonUtils.stringToObj(msg, com.example.goods.entity.Outstorage.class);
        Assert.isNull(outstorage, "参数格式异常");

        Assert.isBlank(outstorage.getCompany(), "单位不能为空");
        Assert.isBlank(outstorage.getDepartment(), "部门不能为空");
        Assert.isBlank(outstorage.getPhone(), "手机号不能为空");
        Assert.isNull(outstorage.getIntime(), "入库时间不能为空");
        Assert.isNull(outstorage.getType(), "入库类型不能为空");
        Assert.isBlank(outstorage.getLinkman(), "联系人不能为空");
        Assert.isNull(outstorage.getGoodsids(), "物资不能为空");
        Assert.isNull(outstorage.getAmount(), "物资数量不能为空");
        //生成编码
        outstorage.setCode(CodeUtil.getOutstorageCode());

        try {
            outstorageServiceImpl.insUserApply(outstorage);
        } catch (Exception e) {
            return Result.ok("发生未知错误！");
        }
        return Result.ok();
    }

    @PostMapping("/passUserApply/{msg}")
    public Result passUserApply(@PathVariable("msg") String msg) {
        Integer goodsid = JsonUtils.stringToObj(msg, Integer.class);

        Assert.isNull(goodsid, "goodsid不能为空");

        try {
            outstorageServiceImpl.passUserApply(goodsid);
        } catch (Exception e) {
            return Result.ok("发生未知错误！");
        }
        return Result.ok();
    }

    /**
     * 修改发放信息
     * @param msg 待修改的信息json对象
     * @return 是否成功
     */
    @PostMapping("/updOutstorageInfo/{msg}")
    public Result updOutstorageInfo(@PathVariable("msg") String msg) {

        Assert.isBlank(msg, "参数不能为空！");
        com.example.goods.entity.Outstorage outstorage = JsonUtils.stringToObj(msg, com.example.goods.entity.Outstorage.class);
        Assert.isNull(outstorage, "参数格式异常");
        Assert.isBlank(outstorage.getCompany(), "单位不能为空");
        Assert.isBlank(outstorage.getDepartment(), "部门不能为空");
        Assert.isBlank(outstorage.getPhone(), "手机号不能为空");
        Assert.isBlank(outstorage.getLinkman(), "联系人不能为空");
        Assert.isNull(outstorage.getGoodsids(), "物资不能为空");
        Assert.isNull(outstorage.getAmount(), "物资数量不能为空");

        try {
            outstorageServiceImpl.updOutstorageInfo(outstorage);
        } catch (Exception e) {
            return Result.ok("发生未知错误！");
        }
        return Result.ok();
    }

    /**
     * 删除发放信息
     * @param msg idJson对象
     * @return 是否成功
     */
    @PostMapping("/delOutstorageInfo/{msg}")
    public Result delOutstorageInfo(@PathVariable("msg") String msg) {
        Integer id = JsonUtils.stringToObj(msg, Integer.class);

        try {
            outstorageServiceImpl.delOutstorageInfo(id);
        } catch (Exception e) {
            return Result.ok("发生未知错误！");
        }
        return Result.ok();
    }
}