package com.dcits.bank.demo.backend.enums;

/**
 * 会计科目代码，由应用层 Enum 统一定义，保证会计分录的科目编码一致。
 */
public enum AccountCode {
    DEMAND_DEPOSIT("1001", "活期存款"),
    CASH_IN_VAULT ("1002", "库存现金"),
    INTEREST_EXPENSE("1003", "利息支出");

    private final String code;
    private final String name;

    AccountCode(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() { return code; }
    public String getName() { return name; }
}
