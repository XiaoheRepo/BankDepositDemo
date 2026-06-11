package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Account {
    private Long accountId;
    private String accountNo;
    private String cardNo;
    private String passwordHash;
    private Long customerId;
    private String accountType;
    private Integer accountLevel;
    private String currency;
    private String branchCode;
    private BigDecimal balance;
    private BigDecimal frozenAmount;
    private Long rateId;
    private LocalDate lastSettlementDate;
    private Integer status;
    private Integer version;
    private LocalDate openDate;
    private LocalDate closeDate;
    private String remark;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;
}
