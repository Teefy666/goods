package com.example.goods.service.impl;

import com.example.goods.mapper.InventoryMapper;
import com.example.goods.service.InventoryService;
import org.springframework.stereotype.Service;

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
    public List<HashMap<String, String>> selInventoryByTypeId(Integer id) {
        return inventoryMapper.selInventoryByTypeId(id);
    }
}