package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 柜员现金尾箱交易明细表 — cash_transaction
 */
@Data
public class CashTransaction {

    /** 现金流水ID（自增主键） */
    private Long cashId;

    /** 关联交易流水ID（关联 business_transaction.trans_id） */
    private Long transId;

    /** 柜员编号 */
    private String tellerId;
    private String branchCode;
    private String boxId;
    private String currency;

    /** 现金类型（I-入库，O-出库） */
    private String cashType;

    /** 金额 */
    private BigDecimal amount;
    private BigDecimal boxBalanceAfter;
    private Integer status;

    /** 备注 */
    private String remark;

    /** 操作时间 */
    private LocalDateTime createdTime;
}
