package com.dcits.bank.demo.backend.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * 身份证号工具，校验 18 位身份证格式及校验码（GB 11643-1999 ISO 7064 MOD 11-2），
 * 并派生性别（17 位奇数→MALE / 偶数→FEMALE）、生日（7-14 位 yyyyMMdd）。
 */
public final class IdCardUtil {

    private static final int[] WEIGHTS = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final char[] CHECK_CODES = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    private static final DateTimeFormatter BIRTH_FMT = DateTimeFormatter.ofPattern("yyyyMMdd");

    private IdCardUtil() {}

    /** 校验 18 位身份证号格式 + 校验码合法性。 */
    public static boolean isValid(String idCardNo) {
        if (idCardNo == null || idCardNo.length() != 18) return false;
        String body = idCardNo.substring(0, 17);
        char given = Character.toUpperCase(idCardNo.charAt(17));
        if (!body.chars().allMatch(Character::isDigit)) return false;
        try {
            LocalDate.parse(body.substring(6, 14), BIRTH_FMT);
        } catch (Exception e) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 17; i++) sum += (body.charAt(i) - '0') * WEIGHTS[i];
        return CHECK_CODES[sum % 11] == given;
    }

    /** 派生性别：第17位奇数→M，偶数→F，调用前需确保 {@link #isValid} 通过。 */
    public static String gender(String idCardNo) {
        int seq = idCardNo.charAt(16) - '0';
        return (seq % 2 == 1) ? "M" : "F";
    }

    /** 派生出生日期。 */
    public static LocalDate birthday(String idCardNo) {
        return LocalDate.parse(idCardNo.substring(6, 14), BIRTH_FMT);
    }
}
