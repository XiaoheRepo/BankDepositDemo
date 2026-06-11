package com.dcits.bank.demo.backend.enums;

/** 交易相关枚举（不含 TransType，其面较复杂单独放） */
public class TransactionEnums {

    public enum DcFlag {
        DEBIT("D", "借方/扣减"),
        CREDIT("C", "贷方/增加");
        private final String code;
        private final String desc;
        DcFlag(String code, String desc) { this.code = code; this.desc = desc; }
        public String getCode() { return code; }
        public String getDesc() { return desc; }
    }

    public enum Status {
        PROCESSING(0, "处理中"),
        SUCCESS(1, "成功"),
        FAILED(2, "失败"),
        REVERSED(3, "冲正");
        private final int code;
        private final String desc;
        Status(int code, String desc) { this.code = code; this.desc = desc; }
        public int getCode() { return code; }
        public String getDesc() { return desc; }
    }

    public enum CashType {
        IN("I", "入库"),
        OUT("O", "出库");
        private final String code;
        private final String desc;
        CashType(String code, String desc) { this.code = code; this.desc = desc; }
        public String getCode() { return code; }
        public String getDesc() { return desc; }
    }
}
