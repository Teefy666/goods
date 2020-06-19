package com.example.goods.entity;

import lombok.Data;
import java.util.Date;

/**
 * @author TongTianFu
 * @date 2020/5/25
 */
@Data
public class Outstorage {
	private Integer id;
	private String code;
	private Integer companyid;
	private Integer departmentid;
	private String linkmanid;
	private String phone;
	private Date outtime;
	private Integer type;
	private String goodsids;
	private String amount;
	private Integer status;
}