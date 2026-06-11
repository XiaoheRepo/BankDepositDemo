package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class InterestSettlement {
    private Long settlementId;
    private Long accountId;
    private LocalDate settlementDate;
    private BigDecimal accumulatedAmount;
    private BigDecimal appliedRate;
    private Integer interestDays;
    private BigDecimal interestAmount;
    private Long transId;
    private LocalDateTime createdTime;
}
