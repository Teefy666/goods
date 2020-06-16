package com.example.goods.service.impl;

import com.example.goods.mapper.InventoryMapper;
import com.example.goods.service.InventoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/13
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Resource
    private InventoryMapper inventoryMapper;

    @Override
    public List<HashMap<String, String>> selInventory(Integer id, String name) {
        return inventoryMapper.selInventory(id, name);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updAmounts(Integer id, Integer amount) {
        return inventoryMapper.updAmounts(id, amount);
    }
}