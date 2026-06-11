package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.BusinessTransaction;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BusinessTransactionMapper {

    @Select("SELECT * FROM business_transaction WHERE out_trade_no = #{outTradeNo}")
    BusinessTransaction selectByOutTradeNo(@Param("outTradeNo") String outTradeNo);

    @Select("SELECT * FROM business_transaction WHERE trans_id = #{transId}")
    BusinessTransaction selectById(@Param("transId") Long transId);

    @Insert("INSERT INTO business_transaction (out_trade_no, related_trans_id, account_id, counter_party_account, " +
            "dc_flag, trans_type, trans_amount, balance_after, channel, operator_id, trans_time, status, remark) " +
            "VALUES (#{outTradeNo}, #{relatedTransId}, #{accountId}, #{counterPartyAccount}, #{dcFlag}, " +
            "#{transType}, #{transAmount}, #{balanceAfter}, #{channel}, #{operatorId}, #{transTime}, #{status}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "transId")
    int insert(BusinessTransaction transaction);

    @Select("SELECT * FROM business_transaction WHERE account_id = #{accountId} " +
            "AND trans_time >= #{startTime} AND trans_time <= #{endTime} " +
            "ORDER BY trans_time DESC")
    List<BusinessTransaction> selectByAccountAndTime(@Param("accountId") Long accountId,
                                                     @Param("startTime") LocalDateTime startTime,
                                                     @Param("endTime") LocalDateTime endTime);

    @Select("SELECT * FROM business_transaction WHERE account_id = #{accountId} " +
            "AND trans_type = #{transType} AND trans_time >= #{startTime} AND trans_time <= #{endTime} " +
            "ORDER BY trans_time DESC")
    List<BusinessTransaction> selectByAccountTimeAndType(@Param("accountId") Long accountId,
                                                         @Param("startTime") LocalDateTime startTime,
                                                         @Param("endTime") LocalDateTime endTime,
                                                         @Param("transType") String transType);
}
