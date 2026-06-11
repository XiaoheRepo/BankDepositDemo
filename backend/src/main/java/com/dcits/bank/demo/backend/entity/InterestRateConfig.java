package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 利率配置表 — interest_rate_config
 */
@Data
public class InterestRateConfig {

    /** 利率ID（自增主键） */
    private Long rateId;

    /** 利率名称 */
    private String rateName;

    /** 适用账户类型（C01-活期存款） */
    private String accountType;

    /** 适用币种 */
    private String currency;

    /** 利率值（高精度日利率，DECIMAL(12,8)） */
    private BigDecimal rateValue;

    /** 生效日期 */
    private LocalDate effectiveDate;

    /** 失效日期 */
    private LocalDate expiryDate;

    /** 状态（1-有效，0-失效） */
    private Integer status;

    /** 创建时间 */
    private LocalDateTime createdTime;

    /** 最后更新时间 */
    private LocalDateTime updateTime;
}
