package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 账户日积数底表 — daily_balance
 */
@Data
public class DailyBalance {

    /** 日积数ID（自增主键） */
    private Long dailyBalanceId;

    /** 内部账户ID（关联 account.account_id） */
    private Long accountId;
    private String currency;

    /** 余额所属日期（与account_id组成唯一约束 uk_account_date） */
    private LocalDate balanceDate;

    /** 当日最终余额（日积数，结息计算的基础数据） */
    private BigDecimal endBalance;

    /** 创建时间 */
    private LocalDateTime createdTime;

    /** 最后更新时间 */
    private LocalDateTime updateTime;
}
