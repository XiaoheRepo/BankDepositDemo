package com.dcits.bank.demo.backend.service;

import com.dcits.bank.demo.backend.entity.AccountingEntry;
import com.dcits.bank.demo.backend.entity.BusinessTransaction;
import com.dcits.bank.demo.backend.enums.*;
import com.dcits.bank.demo.backend.mapper.AccountingEntryMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 会计分录服务，根据交易流水 + 交易类型枚举中的分录模板，
 * 统一生成一借一贷两条 accounting_entry，确保借贷平衡。
 */
@Service
public class AccountingService {

    private final AccountingEntryMapper entryMapper;

    public AccountingService(AccountingEntryMapper entryMapper) {
        this.entryMapper = entryMapper;
    }

    /**
     * 根据一笔交易流水生成两条会计分录（1借 + 1贷）。
     */
    public void generateEntries(BusinessTransaction trans) {
        TransType tt = TransType.fromCode(trans.getTransType());
        String voucherId = "VCH" + trans.getTransId();

        AccountCode debitCode;
        AccountCode creditCode;
        String debitSummary;
        String creditSummary;
        BigDecimal amount = trans.getTransAmount();

        // 转账由 DcFlag 决定分录方向：转出(D)→借1001贷1002，转入(C)→借1002贷1001
        if (tt == TransType.TRANSFER && DcFlag.CREDIT.getCode().equals(trans.getDcFlag())) {
            debitCode = tt.getCreditCode();
            creditCode = tt.getDebitCode();
            debitSummary = "内部清算";
            creditSummary = "活期存款入账";
        } else {
            debitCode = tt.getDebitCode();
            creditCode = tt.getCreditCode();
            debitSummary = tt.getDebitSummary();
            creditSummary = tt.getCreditSummary();
        }

        // 借方分录
        entryMapper.insert(buildEntry(voucherId, trans.getTransId(),
                debitCode.getCode(), AccountingAction.DEBIT.getCode(), amount, debitSummary));

        // 贷方分录
        entryMapper.insert(buildEntry(voucherId, trans.getTransId(),
                creditCode.getCode(), AccountingAction.CREDIT.getCode(), amount, creditSummary));
    }

    private AccountingEntry buildEntry(String voucherId, Long transId,
                                       String accountCode, int action,
                                       BigDecimal amount, String summary) {
        AccountingEntry entry = new AccountingEntry();
        entry.setVoucherId(voucherId);
        entry.setTransId(transId);
        entry.setAccountCode(accountCode);
        entry.setAction(action);
        entry.setAmount(amount);
        entry.setSummary(summary);
        return entry;
    }
}
