package com.example.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;

/**
 * @author TongTianFu
 * @date 2020/5/25
 */
@Data
@AllArgsConstructor
public class Goods {
 	 private Integer id;
 	 private String code;
 	 private Integer typeid;
 	 private String name;
 	 private String unit;
 	 private String specifications;
 	 private String producer;
 	 private String remark;
 	 private String image;
}