package com.example.goods.controller;

import com.example.goods.entity.Goods;
import com.example.goods.service.GoodsService;
import com.example.goods.utils.Assert;
import com.example.goods.utils.JsonUtils;
import com.example.goods.utils.RRException;
import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param msg 物资资料Json对象
     * @return 是否成功
     */
    @PostMapping("/addGoods/{msg}")
    public Result addGoods(@PathVariable("msg") String msg) {
        Goods goods = JsonUtils.stringToObj("msg", Goods.class);
        //验证
        Assert.isNull(goods, "goods不能为空");

        try {
            goodsServiceImpl.insGoods(goods);
        } catch (Exception e) {
            return Result.error("发生未知错误!");
        }
        return Result.ok("添加成功！");
    }

    /**
     * 根据类型id查询物资资料
     * @param msg 物资资料id，name
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
     * @param msg 资料json对象
     * @return 是否成功
     */
    @PostMapping("/updGoods/{msg}")
    public Result updGoods(@PathVariable("msg") String msg) {
        Goods goods = JsonUtils.stringToObj("msg", Goods.class);

        //验证
        Assert.isNull(goods, "goods不能为空");

        try {
            goodsServiceImpl.updGoods(goods);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }

        return Result.ok("添加成功！");
    }

    /**
     * 删除物资资料
     * @param msg 资料id json对象
     * @return 是否成功
     */
    @PostMapping("/delGoods/{msg}")
    public Result delGoods(@PathVariable("msg") String msg) {
        Integer id = JsonUtils.stringToObj(msg, Integer.class);

        Assert.isNull(id, "id不能为空");

        try {
            goodsServiceImpl.delGoods(id);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok("删除成功！");
    }
}