package com.dcits.bank.demo.backend.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 会计分录明细表 — accounting_entry
 */
@Data
public class AccountingEntry {

    /** 分录流水ID（自增主键） */
    private Long entryId;

    /** 所属记账凭证号 */
    private String voucherId;

    /** 所属业务流水ID（关联 business_transaction.trans_id） */
    private Long transId;

    /** 会计科目代码（由 AccountCode 枚举统一定义） */
    private String accountCode;

    /** 借贷方向（1-借，2-贷） */
    private Integer action;

    /** 发生金额绝对值 */
    private BigDecimal amount;

    /** 分录摘要 */
    private String summary;

    /** 记账时间 */
    private LocalDateTime createdTime;
}
