package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.InterestRateConfig;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InterestRateConfigMapper {

    @Select("SELECT * FROM interest_rate_config WHERE rate_id = #{rateId} AND status = 1")
    InterestRateConfig selectByRateId(@Param("rateId") Long rateId);

    @Select("SELECT * FROM interest_rate_config WHERE account_type = #{accountType} AND currency = #{currency} " +
            "AND status = 1 AND effective_date <= #{date} AND (expiry_date IS NULL OR expiry_date >= #{date}) " +
            "ORDER BY effective_date DESC LIMIT 1")
    InterestRateConfig selectActiveRate(@Param("accountType") String accountType,
                                        @Param("currency") String currency,
                                        @Param("date") java.time.LocalDate date);
}
