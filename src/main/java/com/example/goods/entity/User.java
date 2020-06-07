package com.example.goods.entity;

import lombok.Data;
import java.util.Date;

/**
 * @author TongTianFu
 * @date 2020/5/25
 */
@Data
public class User { 	 private Integer id; 	 private String account; 	 private String password; 	 private String name; 	 private Integer age; 	 private String gender; 	 private String phone; 	 private String remark; 	 private String head; 	 private Integer departmentid; 	 private Integer roleid;
}