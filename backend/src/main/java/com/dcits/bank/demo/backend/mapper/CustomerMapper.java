package com.dcits.bank.demo.backend.mapper;

import com.dcits.bank.demo.backend.entity.Customer;
import org.apache.ibatis.annotations.*;

/**
 * 客户信息表 Mapper
 */
@Mapper
public interface CustomerMapper {

    /** 根据证件类型+证件号码查询客户（唯一约束 uk_id_type_number） */
    @Select("SELECT * FROM customer WHERE id_type = #{idType} AND id_number = #{idNumber}")
    Customer selectByIdTypeAndIdNumber(@Param("idType") String idType, @Param("idNumber") String idNumber);

    /** 根据主键查询客户 */
    @Select("SELECT * FROM customer WHERE customer_id = #{customerId}")
    Customer selectById(@Param("customerId") Long customerId);

    /** 新增客户，返回自增主键 customerId */
    @Insert("INSERT INTO customer (customer_name, type, id_type, id_number, phone, address, date_of_birth, gender, branch, status) " +
            "VALUES (#{customerName}, #{type}, #{idType}, #{idNumber}, #{phone}, #{address}, #{dateOfBirth}, #{gender}, #{branch}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "customerId")
    int insert(Customer customer);

    /** 更新非关键联系信息（电话、地址） */
    @Update("UPDATE customer SET phone = #{phone}, address = #{address} WHERE customer_id = #{customerId}")
    int updateContact(Customer customer);
}
