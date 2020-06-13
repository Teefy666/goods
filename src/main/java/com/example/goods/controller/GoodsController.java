package com.example.goods.controller;

import com.example.goods.entity.Goods;
import com.example.goods.service.GoodsService;
import com.example.goods.utils.Assert;
import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
     * @param goods 资料对象
     * @return 是否成功
     */
    @RequestMapping("/addGoods")
    public Result addGoods(Goods goods) {
        //验证


        try {
            goodsServiceImpl.insGoods(goods);
        } catch (Exception e) {
            return Result.error("发生未知错误!");
        }
        return Result.ok("添加成功！");
    }

    /**
     * 根据类型id查询物资资料
     * @param id 类型id
     * @param name 物资名
     * @return 物资资料
     */
    @RequestMapping("/getGoods")
    public Result getGoods(Integer id, String name) {
        return Result.ok().put("list", goodsServiceImpl.selGoods(id, name));
    }

    /**
     * 修改物资资料
     * @param goods 资料对象
     * @return 是否成功
     */
    @RequestMapping("/updGoods")
    public Result updGoods(Goods goods) {
        //验证


        try {
            goodsServiceImpl.updGoods(goods);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }

        return Result.ok("添加成功！");
    }

    /**
     * 删除物资资料
     * @param id 资料id
     * @return 是否成功
     */
    @RequestMapping("/delGoods")
    public Result delGoods(Integer id) {
        Assert.isNull(id, "id不能为空！");

        try {
            goodsServiceImpl.delGoods(id);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok("删除成功！");
    }
}