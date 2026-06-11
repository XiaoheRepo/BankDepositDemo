package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.InterestRateConfig;
import org.apache.ibatis.annotations.*;

/**
 * 利率配置表 Mapper
 */
@Mapper
public interface InterestRateConfigMapper {

    /** 根据主键查询有效利率 */
    @Select("SELECT * FROM interest_rate_config WHERE rate_id = #{rateId} AND status = 1")
    InterestRateConfig selectByRateId(@Param("rateId") Long rateId);

    /** 按账户类型+币种+日期匹配当前有效利率（取最新生效的一条） */
    @Select("SELECT * FROM interest_rate_config WHERE account_type = #{accountType} AND currency = #{currency} " +
            "AND status = 1 AND effective_date <= #{date} AND (expiry_date IS NULL OR expiry_date >= #{date}) " +
            "ORDER BY effective_date DESC LIMIT 1")
    InterestRateConfig selectActiveRate(@Param("accountType") String accountType,
                                        @Param("currency") String currency,
                                        @Param("date") java.time.LocalDate date);
}
