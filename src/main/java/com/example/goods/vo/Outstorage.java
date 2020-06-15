package com.example.goods.vo;

import com.example.goods.utils.ListTransform;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author TongTianFu
 * @date 2020/5/25
 */
@Data
public class Outstorage {
 	 private Integer id;
 	 private String code;
 	 private String company;
 	 private String department;
 	 private String phone;
 	 private Date outtime;
 	 private Integer type;
 	 private String linkman;
 	 private List<Integer> goodsidsList;
 	 private List<Integer> amountList;
 	 private List<HashMap<String, Object>> goodsList;

 	 public Outstorage(com.example.goods.entity.Outstorage outstorage) {
 	 	this.id = outstorage.getId();
 	 	this.code = outstorage.getCode();
 	 	this.company = outstorage.getCompany();
 	 	this.department = outstorage.getDepartment();
 	 	this.phone = outstorage.getPhone();
 	 	this.outtime = outstorage.getIntime();
 	 	this.type = outstorage.getType();
 	 	this.linkman = outstorage.getLinkman();
 	 	//把逗号分隔的转化为数组
		this.goodsidsList = ListTransform.stringToList(outstorage.getGoodsids());
		this.amountList = ListTransform.stringToList(outstorage.getAmount());
	 }
}