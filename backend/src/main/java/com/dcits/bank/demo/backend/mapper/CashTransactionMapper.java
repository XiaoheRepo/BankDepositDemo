package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.CashTransaction;
import org.apache.ibatis.annotations.*;

/**
 * 柜员现金尾箱交易明细表 Mapper
 */
@Mapper
public interface CashTransactionMapper {

    /** 新增现金出入库记录（柜面渠道存款/取款时调用） */
    @Insert("INSERT INTO cash_transaction (trans_id, teller_id, cash_type, amount, remark) " +
            "VALUES (#{transId}, #{tellerId}, #{cashType}, #{amount}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "cashId")
    int insert(CashTransaction cashTransaction);
}
