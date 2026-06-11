package com.dcits.bank.demo.backend.enums;

/** 会计相关枚举 */
public class AccountingEnums {

    /** 会计科目代码 */
    public enum AccountCode {
        DEMAND_DEPOSIT    ("1001", "活期存款"),
        CASH_IN_VAULT     ("1002", "库存现金"),
        INTEREST_EXPENSE  ("1003", "利息支出"),
        INTERNAL_CLEARING ("1004", "行内清算");
        private final String code;
        private final String name;
        AccountCode(String code, String name) { this.code = code; this.name = name; }
        public String getCode() { return code; }
        public String getName() { return name; }
    }

    /** 借贷方向 */
    public enum Action {
        DEBIT(1, "借"),
        CREDIT(2, "贷");
        private final int code;
        private final String desc;
        Action(int code, String desc) { this.code = code; this.desc = desc; }
        public int getCode() { return code; }
        public String getDesc() { return desc; }
    }
}
