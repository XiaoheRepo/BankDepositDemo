package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 结息审计记录表 — interest_settlement
 */
@Data
public class InterestSettlement {

    /** 结息记录ID（自增主键） */
    private Long settlementId;

    /** 内部账户ID（关联 account.account_id） */
    private Long accountId;
    private String currency;

    /** 结息执行日期 */
    private LocalDate settlementDate;

    /** 该周期内总积数（日积数汇总值） */
    private BigDecimal accumulatedAmount;

    /** 执行时的日利率（DECIMAL(12,8)） */
    private BigDecimal appliedRate;

    /** 计息总天数 */
    private Integer interestDays;

    /** 最终派发利息金额 */
    private BigDecimal interestAmount;

    /** 关联生成的利息派发流水ID（关联 business_transaction.trans_id） */
    private Long transId;

    /** 记录创建时间 */
    private LocalDateTime createdTime;
}
