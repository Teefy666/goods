package com.example.goods.controller;

import com.example.goods.service.OutstorageService;
import com.example.goods.utils.*;
import com.example.goods.vo.Outstorage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
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
     * @param msg type，联系人
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
        //直接返回
        return Result.ok().put("outstorage", outstorageServiceImpl.selOutstorageInfo(type, linkman));
    }

    /**
     * 添加发放信息
     * @param outstorage 发放信息对象
     * @return 是否成功
     */
    @PostMapping("/addOutstorageInfo")
    public Result addOutstorageInfo(@RequestBody com.example.goods.entity.Outstorage outstorage) {
        Assert.isNull(outstorage.getCompanyid(), "单位不能为空");
        Assert.isNull(outstorage.getDepartmentid(), "部门不能为空");
        Assert.isBlank(outstorage.getPhone(), "手机号不能为空");
        Assert.isNull(outstorage.getType(), "入库类型不能为空");
        Assert.isBlank(outstorage.getLinkmanid(), "联系人不能为空");
        Assert.isNull(outstorage.getGoodsids(), "物资不能为空");
        Assert.isNull(outstorage.getAmount(), "物资数量不能为空");

        //设置编码
        outstorage.setCode(CodeUtil.getOutstorageCode());
        outstorage.setStatus(1);
        outstorage.setIntime(new Date());
        try {
            outstorageServiceImpl.insOutstorageInfo(outstorage);
        } catch (RRException e) {
            return Result.error("库存数量不足！");
        }  catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok();
    }

    /**
     * 提交用户申请发放
     * @param outstorage 发放信息对象
     * @return 是否成功
     */
    @PostMapping("/addUserApply")
    public Result addUserApply(@RequestBody com.example.goods.entity.Outstorage outstorage) {
        Assert.isNull(outstorage.getCompanyid(), "单位不能为空");
        Assert.isNull(outstorage.getDepartmentid(), "部门不能为空");
        Assert.isBlank(outstorage.getPhone(), "手机号不能为空");
        Assert.isBlank(outstorage.getLinkmanid(), "联系人不能为空");
        Assert.isNull(outstorage.getGoodsids(), "物资不能为空");
        Assert.isNull(outstorage.getAmount(), "物资数量不能为空");
        //生成编码
        outstorage.setCode(CodeUtil.getOutstorageCode());
        outstorage.setType(2);
        outstorage.setStatus(0);
        outstorage.setIntime(new Date());
        try {
            outstorageServiceImpl.insUserApply(outstorage);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok();
    }

    /**
     * 通过用户申请
     * @param msg goodsid
     * @return 是否成功
     */
    @PostMapping("/passUserApply/{msg}")
    public Result passUserApply(@PathVariable("msg") String msg) {

        try {
            Integer id = Integer.parseInt(msg);
            outstorageServiceImpl.passUserApply(id);

        } catch (RRException e) {
            return Result.error("库存数量不足！");
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok();
    }

    /**
     * 修改发放信息
     * @param outstorage 待修改的发放信息对象
     * @return 是否成功
     */
    @PostMapping("/updOutstorageInfo")
    public Result updOutstorageInfo(@RequestBody com.example.goods.entity.Outstorage outstorage) {
        Assert.isNull(outstorage.getId(), "id不能为空");
        Assert.isNull(outstorage.getCompanyid(), "单位不能为空");
        Assert.isNull(outstorage.getDepartmentid(), "部门不能为空");
        Assert.isBlank(outstorage.getPhone(), "手机号不能为空");
        Assert.isBlank(outstorage.getLinkmanid(), "联系人不能为空");
        Assert.isNull(outstorage.getType(), "类型不能为空");
        Assert.isNull(outstorage.getGoodsids(), "物资不能为空");
        Assert.isNull(outstorage.getAmount(), "物资数量不能为空");
        Assert.isNull(outstorage.getStatus(), "发放状态不能为空");


        try {
            outstorageServiceImpl.updOutstorageInfo(outstorage);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok();
    }

    /**
     * 删除发放信息
     * @param msg id
     * @return 是否成功
     */
    @PostMapping("/delOutstorageInfo/{msg}")
    public Result delOutstorageInfo(@PathVariable("msg") String msg) {
        Assert.isBlank(msg, "id不能为空");

        try {
            Integer id = Integer.parseInt(msg);
            outstorageServiceImpl.delOutstorageInfo(id);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok();
    }
}