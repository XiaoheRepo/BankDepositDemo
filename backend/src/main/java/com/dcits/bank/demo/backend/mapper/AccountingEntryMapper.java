package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.AccountingEntry;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AccountingEntryMapper {

    @Insert("INSERT INTO accounting_entry (voucher_id, trans_id, account_code, action, amount, summary) " +
            "VALUES (#{voucherId}, #{transId}, #{accountCode}, #{action}, #{amount}, #{summary})")
    @Options(useGeneratedKeys = true, keyProperty = "entryId")
    int insert(AccountingEntry entry);
}
