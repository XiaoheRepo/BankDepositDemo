package com.dcits.bank.demo.backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 交易流水查询响应 — 对应基线文档 功能8 输出要素。
 */
@Data
@AllArgsConstructor
@Schema(description = "交易流水查询响应")
public class TransactionQueryResponse {

    @Schema(description = "满足条件的总记录数")
    private Long totalCount;

    @Schema(description = "交易明细列表")
    private List<TransactionItem> transList;
}
