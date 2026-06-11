package com.dcits.bank.demo.backend.enums;

/** 账户相关枚举 */
public class AccountEnums {

    public enum Type {
        DEMAND_DEPOSIT("C01", "活期存款");
        private final String code;
        private final String desc;
        Type(String code, String desc) { this.code = code; this.desc = desc; }
        public String getCode() { return code; }
        public String getDesc() { return desc; }
    }

    public enum Level {
        LEVEL_I(1, "Ⅰ类户"),
        LEVEL_II(2, "Ⅱ类户"),
        LEVEL_III(3, "Ⅲ类户");
        private final int code;
        private final String desc;
        Level(int code, String desc) { this.code = code; this.desc = desc; }
        public int getCode() { return code; }
        public String getDesc() { return desc; }
    }

    public enum Status {
        NORMAL(0, "正常"),
        FROZEN(1, "冻结"),
        CLOSED(2, "销户");
        private final int code;
        private final String desc;
        Status(int code, String desc) { this.code = code; this.desc = desc; }
        public int getCode() { return code; }
        public String getDesc() { return desc; }
    }
}
