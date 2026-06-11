package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class AccountingEntry {
    private Long entryId;
    private String voucherId;
    private Long transId;
    private String accountCode;
    private Integer action;
    private BigDecimal amount;
    private String summary;
    private LocalDateTime createdTime;
}
