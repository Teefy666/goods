package com.example.goods.service.impl;

import com.example.goods.entity.Outstorage;
import com.example.goods.mapper.OutstorageMapper;
import com.example.goods.service.OutstorageService;
import com.example.goods.utils.ListTransform;
import com.example.goods.utils.RRException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Administrator
 * @date 2020/6/14
 */
@Service
public class OutstorageServiceImpl implements OutstorageService {

    @Resource
    private OutstorageMapper outstorageMapper;

    @Override
    public List<com.example.goods.vo.Outstorage> selOutstorageInfo(Integer type, String linkman) {
        //先查询发放信息
        List<Outstorage> outstorage = outstorageMapper.selOutstorageInfo(type, linkman);
        if (outstorage == null) {
            return null;
        }

        List<com.example.goods.vo.Outstorage> outstorages = new ArrayList<>();

        for (Outstorage out : outstorage) {
            //转化
            com.example.goods.vo.Outstorage outstorage1 = new com.example.goods.vo.Outstorage(out);
            //查询出发放信息附带的库存资料
            List<HashMap<String, Object>> list = outstorageMapper.selGoodsInfos(outstorage1.getGoodsidsList());

            List<Integer> amountList = outstorage1.getAmountList();
            //把库存资料和库存数量匹配
            for (int i = 0; i < list.size(); i++) {
                list.get(i).put("amount", amountList.get(i));
            }

            outstorage1.setGoodsList(list);
            outstorages.add(outstorage1);
        }

        return outstorages;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insOutstorageInfo(Outstorage out) {
        outstorageMapper.insOutstorageInfo(out);

        String goodsids = out.getGoodsids();
        String amount = out.getAmount();
        List<Integer> goodsidsList = ListTransform.stringToList(goodsids);
        List<Integer> amountList = ListTransform.stringToList(amount);
        if (goodsidsList.size() != amountList.size()) {
            throw new RRException("物资数量和物资种类不一致！");
        }
        //当前物资还剩下的数量
        List<Integer> amounts = outstorageMapper.selGoodsAmount(goodsidsList);

        for (int i = 0; i < amountList.size(); i++) {
            if (amountList.get(i) > amounts.get(i)) {
                throw new RRException("库存数量不足！");
            } else {
                outstorageMapper.updAmount(goodsidsList.get(i), amountList.get(i));
            }
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insUserApply(Outstorage out) {
        return outstorageMapper.insOutstorageInfo(out);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer passUserApply(Integer id){
        Outstorage out = outstorageMapper.selOutstorageByid(id);

        String goodsids = out.getGoodsids();
        String amount = out.getAmount();
        List<Integer> goodsidsList = ListTransform.stringToList(goodsids);
        List<Integer> amountList = ListTransform.stringToList(amount);

        //当前物资还剩下的数量
        List<Integer> amounts = outstorageMapper.selGoodsAmount(goodsidsList);

        for (int i = 0; i < amountList.size(); i++) {
            if (amountList.get(i) > amounts.get(i)) {
                throw new RRException("库存数量不足！");
            } else {
                outstorageMapper.updAmount(goodsidsList.get(i), amountList.get(i));
            }
        }
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer updOutstorageInfo(Outstorage out) {
        return outstorageMapper.updOutstorageInfo(out);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer delOutstorageInfo(Integer id) {
        return outstorageMapper.delOutstorageInfo(id);
    }
}