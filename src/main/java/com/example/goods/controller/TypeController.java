package com.example.goods.controller;



import com.example.goods.entity.Type;
import com.example.goods.service.TypeService;
import com.example.goods.utils.Assert;
import com.example.goods.utils.JsonUtils;
import com.example.goods.utils.Result;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/getTypes")
    public Result getTypes() {
        return Result.ok().put("types", typeServiceImpl.selAll());
    }

    /**
     * 添加类型
     * @param msg 类型Json对象
     * @return 是否成功
     */
    @PostMapping("/addTypes/{msg}")
    public Result addTypes(@PathVariable("msg") String msg) {
        Type type = JsonUtils.stringToObj(msg, Type.class);

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
     * @param msg 类型Json对象
     * @return 是否成功
     */
    @PostMapping("/updTypes/{msg}")
    public Result updTypes(@PathVariable("msg") String msg) {
        Type type = JsonUtils.stringToObj(msg, Type.class);

        Assert.isNull(type, "类型不能为空");
        try {
            typeServiceImpl.updType(type);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok("修改成功！");
    }

    /**
     * 删除type
     * @param msg id json对象
     * @return 是否成功
     */
    @PostMapping("/delTypes/{msg}")
    public Result delTypes(@PathVariable("msg") String msg) {
        Integer id = JsonUtils.stringToObj(msg, Integer.class);

        Assert.isNull(id, "id不能为空");
        try {
            typeServiceImpl.delType(id);
        } catch (Exception e) {
            return Result.error("发生未知错误！");
        }
        return Result.ok();
    }
}