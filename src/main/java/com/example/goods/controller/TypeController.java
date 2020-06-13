package com.example.goods.controller;

import com.example.goods.entity.Type;
import com.example.goods.service.TypeService;
import com.example.goods.utils.Assert;
import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @date 2020/6/12
 */
@RequestMapping("/type")
@RestController
public class TypeController {
    @Resource
    private TypeService typeServiceImpl;

    /**
     * 查询全部type
     * @return types
     */
    @RequestMapping("/get")
    public Result getTypes() {
        return Result.ok().put("types", typeServiceImpl.selAll());
    }

    /**
     * 添加type
     * @param type type对象
     * @return 是否成功
     */
    @RequestMapping("/addTypes")
    public Result addTypes(Type type) {
        Assert.isNull(type, "类型不能为空");

        try {
            typeServiceImpl.insType(type);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok("添加成功！");
    }

    /**
     * 修改type
     * @param type type对象
     * @return 是否成功
     */
    @RequestMapping("/addTypes")
    public Result updTypes(Type type) {
        Assert.isNull(type, "类型不能为空");
        try {
            typeServiceImpl.updType(type);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok("修改成功！");
    }

    public Result delTypes(Integer id) {
        Assert.isNull(id, "id不能为空");
        try {
            typeServiceImpl.delType(id);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok();
    }
}