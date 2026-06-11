package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.InterestSettlement;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InterestSettlementMapper {

    @Insert("INSERT INTO interest_settlement (account_id, settlement_date, accumulated_amount, " +
            "applied_rate, interest_days, interest_amount, trans_id) " +
            "VALUES (#{accountId}, #{settlementDate}, #{accumulatedAmount}, #{appliedRate}, " +
            "#{interestDays}, #{interestAmount}, #{transId})")
    @Options(useGeneratedKeys = true, keyProperty = "settlementId")
    int insert(InterestSettlement settlement);
}
