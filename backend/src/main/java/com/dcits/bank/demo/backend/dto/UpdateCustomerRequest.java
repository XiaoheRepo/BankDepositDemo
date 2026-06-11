package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 修改客户信息请求 — 对应基线文档 功能6。
 */
@Data
@Schema(description = "修改客户信息请求")
public class UpdateCustomerRequest {

    @Schema(description = "银行卡号，用于定位客户", example = "6217003588954801077")
    private String cardNo;

    @Schema(description = "账户密码", example = "123456")
    private String password;

    @Schema(description = "联系电话", example = "13811112222")
    private String phone;

    @Schema(description = "通讯地址", example = "北京市海淀区")
    private String address;
}
