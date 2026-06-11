package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 转账请求 — 对应基线文档 功能4 输入要素。
 */
@Data
@Schema(description = "转账请求")
public class TransferRequest {

    @Schema(description = "外部请求幂等号", example = "TRF20260611001")
    private String outTradeNo;

    @Schema(description = "转出方银行卡号", example = "6217003588954801077")
    private String fromCardNo;

    @Schema(description = "转入方银行卡号", example = "6217005771031977676")
    private String toCardNo;

    @Schema(description = "转出方账户密码", example = "123456")
    private String password;

    @Schema(description = "转账金额", example = "2000.00")
    private BigDecimal transAmount;

    @Schema(description = "交易渠道（APP/COUNTER/ATM）", example = "APP")
    private String channel;

    @Schema(description = "经办人/系统标识", example = "APP_USER")
    private String operatorId;

    @Schema(description = "交易摘要", example = "手机银行转账")
    private String remark;
}
