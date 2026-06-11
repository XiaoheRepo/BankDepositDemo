package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 开户请求参数 — 对应基线文档 功能1 输入要素。
 * 出生日期和性别由后端通过身份证号自动派生，前端无需传入。
 */
@Data
@Schema(description = "开户请求")
public class OpenAccountRequest {

    @Schema(description = "客户姓名", example = "张三", maxLength = 50)
    private String customerName;

    @Schema(description = "证件类型（01-身份证，02-护照，03-军官证）", example = "01")
    private String idType;

    @Schema(description = "证件号码。身份证类型时通过IdCardUtil校验并派生出生日期与性别", example = "110101199001011234", maxLength = 30)
    private String idNumber;

    @Schema(description = "账户密码（明文传输，后端做不可逆哈希存储）", example = "123456")
    private String password;

    @Schema(description = "联系电话", example = "13800138000")
    private String phone;

    @Schema(description = "通讯地址", example = "北京市朝阳区", maxLength = 200)
    private String address;

    @Schema(description = "账户等级（1-Ⅰ类，2-Ⅱ类，3-Ⅲ类）", example = "1")
    private Integer accountLevel;

    @Schema(description = "币种，默认CNY", example = "CNY")
    private String currency;

    @Schema(description = "开户行代码", example = "010001")
    private String branchCode;

    @Schema(description = "外部请求幂等号，最长64字符", example = "OPEN20260611001")
    private String outTradeNo;

    @Schema(description = "开户渠道（APP/COUNTER/ATM）", example = "APP")
    private String channel;
}
