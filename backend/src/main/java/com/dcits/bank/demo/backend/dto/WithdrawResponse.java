package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Schema(description = "取款响应")
public class WithdrawResponse {

    @Schema(description = "交易流水号（业务编号）", example = "010001202606110200143005456")
    private String transNo;

    @Schema(description = "取款后账户总余额")
    private BigDecimal balanceAfter;

    @Schema(description = "交易状态（1-成功）")
    private Integer status;
}
