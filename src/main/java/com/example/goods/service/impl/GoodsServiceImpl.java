package com.example.goods.service.impl;

import com.example.goods.entity.Goods;
import com.example.goods.entity.Inventory;
import com.example.goods.mapper.GoodsMapper;
import com.example.goods.mapper.InventoryMapper;
import com.example.goods.service.GoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/12
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private InventoryMapper inventoryMapper;

    @Override
    public List<HashMap<String, Object>> selGoods(Integer id, String name) {
        return goodsMapper.selGoods(id, name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer delGoods(Integer id) {
        //删除goods之前先把inventory删除了
        inventoryMapper.delInventory(id);
        goodsMapper.delGoods(id);
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insGoods(Goods goods) {
        goodsMapper.insGoods(goods);
        //获取新的goodsid
        Integer id = goods.getId();
        //添加goods后添加一个对应的inventory
        inventoryMapper.insInventory(id);
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updGoods(Goods goods) {
        return goodsMapper.updGoods(goods);
    }
}