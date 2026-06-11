package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.AccountingEntry;
import org.apache.ibatis.annotations.*;

/**
 * 会计分录明细表 Mapper
 */
@Mapper
public interface AccountingEntryMapper {

    /** 新增一条分录记录（借或贷），返回自增主键 entryId */
    @Insert("INSERT INTO accounting_entry (voucher_id, trans_id, account_code, action, amount, summary) " +
            "VALUES (#{voucherId}, #{transId}, #{accountCode}, #{action}, #{amount}, #{summary})")
    @Options(useGeneratedKeys = true, keyProperty = "entryId")
    int insert(AccountingEntry entry);
}
