package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 交易明细项 — 对外脱敏后的单条流水记录。
 */
@Data
@AllArgsConstructor
@Schema(description = "交易明细项")
public class TransactionItem {

    @Schema(description = "交易发生时间")
    private String transTime;

    @Schema(description = "交易类型（01-存款，02-取款等）")
    private String transType;

    @Schema(description = "借贷方向（D-支出，C-收入）")
    private String dcFlag;

    @Schema(description = "交易金额绝对值")
    private BigDecimal transAmount;

    @Schema(description = "交易后余额")
    private BigDecimal balanceAfter;

    @Schema(description = "交易摘要")
    private String remark;
}
