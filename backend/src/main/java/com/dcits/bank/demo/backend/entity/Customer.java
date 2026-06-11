package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 客户信息表 — customer
 */
@Data
public class Customer {

    /** 内部客户ID（自增主键） */
    private Long customerId;

    /** 客户姓名 */
    private String customerName;

    /** 客户类型（01-个人，02-企业） */
    private String type;

    /** 证件类型（01-身份证，02-护照，03-军官证） */
    private String idType;

    /** 证件号码（与id_type组成唯一约束 uk_id_type_number） */
    private String idNumber;

    /** 联系电话 */
    private String phone;

    /** 通讯地址 */
    private String address;

    /** 出生日期（身份证开户时由IdCardUtil自动派生） */
    private LocalDate dateOfBirth;

    /** 性别（M-男，F-女，身份证开户时自动派生） */
    private String gender;

    /** 开户机构 */
    private String branch;

    /** 状态（0-正常，1-注销，2-冻结） */
    private Integer status;

    /** 创建时间 */
    private LocalDateTime createdTime;

    /** 最后更新时间 */
    private LocalDateTime updateTime;
}
