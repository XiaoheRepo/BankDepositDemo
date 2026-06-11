package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.InterestSettlement;
import org.apache.ibatis.annotations.*;

/**
 * 结息审计记录表 Mapper
 */
@Mapper
public interface InterestSettlementMapper {

    /** 新增结息审计记录，保存计息积数、利率、天数、利息金额等完整参数 */
    @Insert("INSERT INTO interest_settlement (account_id, settlement_date, accumulated_amount, " +
            "applied_rate, interest_days, interest_amount, trans_id) " +
            "VALUES (#{accountId}, #{settlementDate}, #{accumulatedAmount}, #{appliedRate}, " +
            "#{interestDays}, #{interestAmount}, #{transId})")
    @Options(useGeneratedKeys = true, keyProperty = "settlementId")
    int insert(InterestSettlement settlement);
}
