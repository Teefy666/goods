package com.example.goods.service.impl;

import com.example.goods.entity.Type;
import com.example.goods.mapper.TypeMapper;
import com.example.goods.service.TypeService;

import org.springframework.beans.factory.annotation.Autowired;
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
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Override
    public List<HashMap<String, String>> selAll() {
        return typeMapper.selAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updType(Type type) {
        return typeMapper.updType(type);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int insType(Type type) {
        return typeMapper.insType(type);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int delType(Integer id) {
        return typeMapper.delType(id);
    }
}