package com.dcits.bank.demo.backend.enums;

/**
 * 交易类型，每个枚举值自带复式记账分录模板（1借 + 1贷）。
 * 转账(03)受 DcFlag 影响，规则由 AccountingService 处理。
 */
public enum TransType {

    OPEN_ACCOUNT("00", "开户",
            AccountCode.CASH_IN_VAULT,  AccountCode.DEMAND_DEPOSIT,
            "库存现金",                  "个人活期存款开户"),

    DEPOSIT("01", "存款",
            AccountCode.CASH_IN_VAULT,  AccountCode.DEMAND_DEPOSIT,
            "现金存入",                  "活期存款入账"),

    WITHDRAW("02", "取款",
            AccountCode.DEMAND_DEPOSIT, AccountCode.CASH_IN_VAULT,
            "活期存款支取",              "现金付出"),

    /** 转账分录由 DcFlag 决定：D(转出)→借1001贷1002，C(转入)→借1002贷1001 */
    TRANSFER("03", "转账",
            AccountCode.DEMAND_DEPOSIT, AccountCode.CASH_IN_VAULT,
            "活期存款转出",              "内部清算"),

    INTEREST("04", "结息",
            AccountCode.INTEREST_EXPENSE, AccountCode.DEMAND_DEPOSIT,
            "利息支出",                   "活期存款结息"),

    CLOSE_ACCOUNT("05", "销户",
            AccountCode.DEMAND_DEPOSIT, AccountCode.CASH_IN_VAULT,
            "活期存款销户",              "库存现金");

    private final String code;
    private final String desc;
    private final AccountCode debitCode;   // 借方科目
    private final AccountCode creditCode;  // 贷方科目
    private final String debitSummary;    // 借方摘要
    private final String creditSummary;   // 贷方摘要

    TransType(String code, String desc,
              AccountCode debitCode, AccountCode creditCode,
              String debitSummary, String creditSummary) {
        this.code = code;
        this.desc = desc;
        this.debitCode = debitCode;
        this.creditCode = creditCode;
        this.debitSummary = debitSummary;
        this.creditSummary = creditSummary;
    }

    public String getCode() { return code; }
    public String getDesc() { return desc; }
    public AccountCode getDebitCode() { return debitCode; }
    public AccountCode getCreditCode() { return creditCode; }
    public String getDebitSummary() { return debitSummary; }
    public String getCreditSummary() { return creditSummary; }

    public static TransType fromCode(String code) {
        for (TransType t : values()) {
            if (t.code.equals(code)) return t;
        }
        throw new IllegalArgumentException("未知交易类型: " + code);
    }
}
