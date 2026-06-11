package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BusinessTransaction {
    private Long transId;
    private String outTradeNo;
    private Long relatedTransId;
    private Long accountId;
    private String counterPartyAccount;
    private String dcFlag;
    private String transType;
    private BigDecimal transAmount;
    private BigDecimal balanceAfter;
    private String channel;
    private String operatorId;
    private LocalDateTime transTime;
    private Integer status;
    private String remark;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;
}
