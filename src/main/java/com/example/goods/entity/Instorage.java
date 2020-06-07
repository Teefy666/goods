package com.example.goods.entity;

import lombok.Data;
import java.util.Date;

/**
 * @author TongTianFu
 * @date 2020/5/25
 */
@Data
public class Instorage { 	 private Integer id; 	 private String code; 	 private String company; 	 private String department; 	 private String phone; 	 private Date intime; 	 private Integer type; 	 private String linkman; 	 private String goodsids; 	 private String amount;
}