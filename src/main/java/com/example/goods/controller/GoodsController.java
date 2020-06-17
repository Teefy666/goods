package com.example.goods.controller;

import com.example.goods.entity.Goods;
import com.example.goods.service.GoodsService;
import com.example.goods.utils.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author Administrator
 * @date 2020/6/11
 */
@RequestMapping("/goods")
@RestController
public class GoodsController {

    @Resource
    private GoodsService goodsServiceImpl;

    /**
     * 添加物资资料
     * @param goods 物资资料对象
     * @return 是否成功
     */
    @PostMapping("/addGoods")
    public Result addGoods(@RequestBody Goods goods) {
        Assert.isNull(goods.getTypeid(), "类型id不能为空！");
        Assert.isBlank(goods.getName(), "物资名不能为空！");
        Assert.isBlank(goods.getUnit(), "单位不能为空！");
        Assert.isBlank(goods.getSpecifications(), "规格不能为空！");
        Assert.isBlank(goods.getProducer(), "生产厂家不能为空！");

        goods.setCode(CodeUtil.getGoodsCode());
        try {
            goodsServiceImpl.insGoods(goods);
        } catch (Exception e) {
            return Result.error("发生未知错误!");
        }
        return Result.ok("添加成功！");
    }

    /**
     * 查询物资资料
     * @param msg 类型id，物资name
     * @return 物资资料
     */
    @PostMapping("/getGoods/{msg}")
    public Result getGoods(@PathVariable("msg") String msg) {
        HashMap map = JsonUtils.stringToObj(msg, HashMap.class);
        String idStr = null;
        try {
            idStr = (String) map.get("id");
        } catch (Exception e) {
            throw new RRException("类型id不能为空！");
        }

        Integer id = Integer.parseInt(idStr);
        String name = (String) map.get("name");
        return Result.ok().put("list", goodsServiceImpl.selGoods(id, name));
    }

    /**
     * 修改物资资料
     * @param goods 资料对象
     * @return 是否成功
     */
    @PostMapping("/updGoods")
    public Result updGoods(@RequestBody Goods goods) {
        Assert.isNull(goods.getId(), "id不能为空！");
        Assert.isBlank(goods.getCode(), "编码不能为空！");
        Assert.isNull(goods.getTypeid(), "类型id不能为空！");
        Assert.isBlank(goods.getName(), "物资名不能为空！");
        Assert.isBlank(goods.getUnit(), "单位不能为空！");
        Assert.isBlank(goods.getSpecifications(), "规格不能为空！");
        Assert.isBlank(goods.getProducer(), "生产厂家不能为空！");

        try {
            goodsServiceImpl.updGoods(goods);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }

        return Result.ok("修改成功！");
    }

    /**
     * 删除物资资料
     * @param msg 资料id json对象
     * @return 是否成功
     */
    @PostMapping("/delGoods/{msg}")
    public Result delGoods(@PathVariable("msg") String msg) {
        Assert.isBlank(msg, "id不能为空");

        try {
            Integer id = Integer.parseInt(msg);
            goodsServiceImpl.delGoods(id);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok("删除成功！");
    }
}