package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CashTransaction {
    private Long cashId;
    private Long transId;
    private String tellerId;
    private String cashType;
    private BigDecimal amount;
    private String remark;
    private LocalDateTime createdTime;
}
