package com.example.goods.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author TongTianFu
 * @date 2020/5/25
 */
@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String gender;
    private String phone;
    private String remark;
    private Integer departmentid;
    private Integer roleid;
}
