package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InterestRateConfig {
    private Long rateId;
    private String rateName;
    private String accountType;
    private String currency;
    private BigDecimal rateValue;
    private LocalDate effectiveDate;
    private LocalDate expiryDate;
    private Integer status;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;
}
