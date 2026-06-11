package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.BusinessTransaction;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 业务交易流水表 Mapper
 */
@Mapper
public interface BusinessTransactionMapper {

    /** 根据幂等号查询（唯一索引 uk_out_trade_no），用于幂等防重 */
    @Select("SELECT * FROM business_transaction WHERE out_trade_no = #{outTradeNo}")
    BusinessTransaction selectByOutTradeNo(@Param("outTradeNo") String outTradeNo);

    /** 根据主键查询交易流水 */
    @Select("SELECT * FROM business_transaction WHERE trans_id = #{transId}")
    BusinessTransaction selectById(@Param("transId") Long transId);

    /** 新增交易流水，返回自增主键 transId */
    @Insert("INSERT INTO business_transaction (out_trade_no, related_trans_id, account_id, counter_party_account, " +
            "dc_flag, trans_type, trans_amount, balance_after, channel, operator_id, trans_time, status, remark) " +
            "VALUES (#{outTradeNo}, #{relatedTransId}, #{accountId}, #{counterPartyAccount}, #{dcFlag}, " +
            "#{transType}, #{transAmount}, #{balanceAfter}, #{channel}, #{operatorId}, #{transTime}, #{status}, #{remark})")
    @Options(useGeneratedKeys = true, keyProperty = "transId")
    int insert(BusinessTransaction transaction);

    /** 按账户+时间范围查询全部流水（用于内部调用），利用 idx_acc_time 复合索引 */
    @Select("SELECT * FROM business_transaction WHERE account_id = #{accountId} " +
            "AND trans_time >= #{startTime} AND trans_time <= #{endTime} " +
            "ORDER BY trans_time DESC")
    List<BusinessTransaction> selectByAccountAndTime(@Param("accountId") Long accountId,
                                                     @Param("startTime") LocalDateTime startTime,
                                                     @Param("endTime") LocalDateTime endTime);

    /** 更新关联流水号，转账双流水建立双向绑定 */
    @Update("UPDATE business_transaction SET related_trans_id = #{relatedTransId} WHERE trans_id = #{transId}")
    int updateRelatedTransId(@Param("transId") Long transId, @Param("relatedTransId") Long relatedTransId);

    /** 按账户+时间+交易类型查询（内部调用） */
    @Select("SELECT * FROM business_transaction WHERE account_id = #{accountId} " +
            "AND trans_type = #{transType} AND trans_time >= #{startTime} AND trans_time <= #{endTime} " +
            "ORDER BY trans_time DESC")
    List<BusinessTransaction> selectByAccountTimeAndType(@Param("accountId") Long accountId,
                                                         @Param("startTime") LocalDateTime startTime,
                                                         @Param("endTime") LocalDateTime endTime,
                                                         @Param("transType") String transType);

    /** 分页查询总量，支持可选 transType 过滤 */
    @Select("<script>" +
            "SELECT COUNT(*) FROM business_transaction WHERE account_id = #{accountId} " +
            "AND trans_time >= #{startTime} AND trans_time &lt;= #{endTime} " +
            "<if test='transType != null'> AND trans_type = #{transType}</if>" +
            "</script>")
    long countByAccountAndTime(@Param("accountId") Long accountId,
                               @Param("startTime") LocalDateTime startTime,
                               @Param("endTime") LocalDateTime endTime,
                               @Param("transType") String transType);

    /** 分页查询交易明细，支持可选 transType 过滤，按时间倒序 */
    @Select("<script>" +
            "SELECT * FROM business_transaction WHERE account_id = #{accountId} " +
            "AND trans_time >= #{startTime} AND trans_time &lt;= #{endTime} " +
            "<if test='transType != null'> AND trans_type = #{transType}</if>" +
            "ORDER BY trans_time DESC LIMIT #{limit} OFFSET #{offset}" +
            "</script>")
    List<BusinessTransaction> selectByAccountAndTimePaged(@Param("accountId") Long accountId,
                                                          @Param("startTime") LocalDateTime startTime,
                                                          @Param("endTime") LocalDateTime endTime,
                                                          @Param("transType") String transType,
                                                          @Param("limit") int limit,
                                                          @Param("offset") int offset);
}
