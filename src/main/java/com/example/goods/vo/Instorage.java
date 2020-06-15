package com.example.goods.vo;

import com.example.goods.utils.ListTransform;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author TongTianFu
 * @date 2020/5/25
 */
@Data
public class Instorage {
 	 private Integer id;
 	 private String code;
 	 private String company;
 	 private String department;
 	 private String phone;
 	 private Date intime;
 	 private Integer type;
 	 private String linkman;
 	 private List<Integer> goodsidsList;
 	 private List<Integer> amountList;
 	 private List<HashMap<String, Object>> goodsList;

 	 public Instorage(com.example.goods.entity.Instorage instorage) {
 	 	this.id = instorage.getId();
 	 	this.code = instorage.getCode();
 	 	this.company = instorage.getCompany();
 	 	this.department = instorage.getDepartment();
 	 	this.phone = instorage.getPhone();
 	 	this.intime = instorage.getIntime();
 	 	this.type = instorage.getType();
 	 	this.linkman = instorage.getLinkman();
 	 	//把逗号分隔的转化为数组
		this.goodsidsList = ListTransform.stringToList(instorage.getGoodsids());
		this.amountList = ListTransform.stringToList(instorage.getAmount());
	 }
}