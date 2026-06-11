package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 交易流水查询请求 — 对应基线文档 功能8 输入要素。
 */
@Data
@Schema(description = "交易流水查询请求")
public class TransactionQueryRequest {

    @Schema(description = "银行卡号", example = "6217003588954801077")
    private String cardNo;

    @Schema(description = "账户密码", example = "123456")
    private String password;

    @Schema(description = "查询起始时间，格式 yyyy-MM-dd HH:mm:ss", example = "2026-01-01 00:00:00")
    private String startDate;

    @Schema(description = "查询结束时间，格式 yyyy-MM-dd HH:mm:ss", example = "2026-06-11 23:59:59")
    private String endDate;

    @Schema(description = "交易类型（01-存款/02-取款等），不传则查全部")
    private String transType;

    @Schema(description = "页码，从1开始", example = "1")
    private Integer pageNum;

    @Schema(description = "每页条数", example = "10")
    private Integer pageSize;
}
