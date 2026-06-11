package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 转账响应 — 对应基线文档 功能4 输出要素。
 */
@Data
@AllArgsConstructor
@Schema(description = "转账响应")
public class TransferResponse {

    @Schema(description = "转出方交易流水号")
    private Long fromTransId;

    @Schema(description = "转入方交易流水号")
    private Long toTransId;

    @Schema(description = "转出方交易后余额")
    private BigDecimal fromBalanceAfter;

    @Schema(description = "交易状态（1-成功）")
    private Integer status;
}
