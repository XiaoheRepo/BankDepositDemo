package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.DailyBalance;
import org.apache.ibatis.annotations.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Mapper
public interface DailyBalanceMapper {

    @Insert("INSERT INTO daily_balance (account_id, balance_date, end_balance) VALUES (#{accountId}, #{balanceDate}, #{endBalance})")
    @Options(useGeneratedKeys = true, keyProperty = "dailyBalanceId")
    int insert(DailyBalance dailyBalance);

    @Select("SELECT IFNULL(SUM(end_balance), 0) FROM daily_balance WHERE account_id = #{accountId} " +
            "AND balance_date >= #{startDate} AND balance_date <= #{endDate}")
    BigDecimal sumBalanceByAccountAndDateRange(@Param("accountId") Long accountId,
                                               @Param("startDate") LocalDate startDate,
                                               @Param("endDate") LocalDate endDate);
}
