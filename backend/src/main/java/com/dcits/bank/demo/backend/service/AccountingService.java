package com.dcits.bank.demo.backend.service;

import com.dcits.bank.demo.backend.entity.AccountingEntry;
import com.dcits.bank.demo.backend.entity.BusinessTransaction;
import com.dcits.bank.demo.backend.enums.*;
import com.dcits.bank.demo.backend.mapper.AccountingEntryMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 会计分录服务，根据交易流水 + 交易类型枚举中的分录模板，
 * 统一生成一借一贷两条 accounting_entry，确保借贷平衡。
 */
@Service
public class AccountingService {

    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyyMMdd");

    private final AccountingEntryMapper entryMapper;

    public AccountingService(AccountingEntryMapper entryMapper) {
        this.entryMapper = entryMapper;
    }

    /**
     * 根据一笔交易流水生成两条会计分录（1借 + 1贷）。
     * @param trans      交易流水
     * @param branchCode 开户机构号，用于拼凭证号
     */
    public void generateEntries(BusinessTransaction trans, String branchCode) {
        // 1. 从枚举模板取借贷科目及摘要
        TransType tt = TransType.fromCode(trans.getTransType());

        // 2. 拼凭证号：机构号 + 日期 + 交易类型 + 流水号
        String voucherId = buildVoucherId(branchCode, trans.getTransType(), trans.getTransId());

        AccountCode debitCode;
        AccountCode creditCode;
        String debitSummary;
        String creditSummary;
        BigDecimal amount = trans.getTransAmount();

        // 3. 转账取转入/转出方向：转出(D)用模板正向，转入(C)交换借贷科目
        if (tt == TransType.TRANSFER && DcFlag.CREDIT.getCode().equals(trans.getDcFlag())) {
            // 转入方：借1004行内清算 / 贷1001活期存款
            debitCode = tt.getCreditCode();
            creditCode = tt.getDebitCode();
            debitSummary = "行内清算";
            creditSummary = "活期存款入账";
        } else {
            // 通用：直接取模板配置
            debitCode = tt.getDebitCode();
            creditCode = tt.getCreditCode();
            debitSummary = tt.getDebitSummary();
            creditSummary = tt.getCreditSummary();
        }

        // 4. 写入借方分录
        entryMapper.insert(buildEntry(voucherId, trans.getTransId(),
                debitCode.getCode(), AccountingAction.DEBIT.getCode(), amount, debitSummary));

        // 5. 写入贷方分录
        entryMapper.insert(buildEntry(voucherId, trans.getTransId(),
                creditCode.getCode(), AccountingAction.CREDIT.getCode(), amount, creditSummary));
    }

    /**
     * 凭证号格式：机构号(6位) + 日期(8位 yyyyMMdd) + 交易类型(2位) + 流水号(12位左补零)
     * 例：0100012026061101000000000001
     */
    private String buildVoucherId(String branchCode, String transType, Long transId) {
        String datePart = LocalDate.now().format(DATE_FMT);
        String transIdPart = String.format("%012d", transId);
        return branchCode + datePart + transType + transIdPart;
    }

    /** 组装一条会计分录实体 */
    private AccountingEntry buildEntry(String voucherId, Long transId,
                                       String accountCode, int action,
                                       BigDecimal amount, String summary) {
        AccountingEntry entry = new AccountingEntry();
        entry.setVoucherId(voucherId);
        entry.setTransId(transId);
        entry.setAccountCode(accountCode);
        entry.setAction(action);      // 1-借，2-贷
        entry.setAmount(amount);
        entry.setSummary(summary);
        return entry;
    }
}
