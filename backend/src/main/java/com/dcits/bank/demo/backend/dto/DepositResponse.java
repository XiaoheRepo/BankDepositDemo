package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Schema(description = "存款响应")
public class DepositResponse {

    @Schema(description = "交易流水号（业务编号）", example = "010001202606110100143005123")
    private String transNo;

    @Schema(description = "存款后账户总余额")
    private BigDecimal balanceAfter;

    @Schema(description = "交易状态（1-成功）")
    private Integer status;
}
