package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DailyBalance {
    private Long dailyBalanceId;
    private Long accountId;
    private LocalDate balanceDate;
    private BigDecimal endBalance;
    private LocalDateTime createdTime;
    private LocalDateTime updateTime;
}
