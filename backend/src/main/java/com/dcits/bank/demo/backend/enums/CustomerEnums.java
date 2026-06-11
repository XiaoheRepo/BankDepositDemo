package com.dcits.bank.demo.backend.enums;

/** 客户相关枚举 */
public class CustomerEnums {

    public enum Type {
        PERSONAL("01", "个人"),
        CORPORATE("02", "企业");
        private final String code;
        private final String desc;
        Type(String code, String desc) { this.code = code; this.desc = desc; }
        public String getCode() { return code; }
        public String getDesc() { return desc; }
    }

    public enum Status {
        NORMAL(0, "正常"),
        CANCELLED(1, "注销"),
        FROZEN(2, "冻结");
        private final int code;
        private final String desc;
        Status(int code, String desc) { this.code = code; this.desc = desc; }
        public int getCode() { return code; }
        public String getDesc() { return desc; }
    }
}
