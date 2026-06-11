package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.CashTransaction;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CashTransactionMapper {

    @Insert("INSERT INTO cash_transaction (trans_id, teller_id, cash_type, amount, remark) " +
            "VALUES (#{transId}, #{tellerId}, #{cashType}, #{amount}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "cashId")
    int insert(CashTransaction cashTransaction);
}
