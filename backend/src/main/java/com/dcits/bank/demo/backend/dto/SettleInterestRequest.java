package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 结息请求 DTO
 */
@Data
@Schema(description = "结息请求")
public class SettleInterestRequest {

    @Schema(description = "银行卡号")
    private String cardNo;

    @Schema(description = "账户密码")
    private String password;
}