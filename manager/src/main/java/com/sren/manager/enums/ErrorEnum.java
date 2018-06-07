package com.sren.manager.enums;

import lombok.Getter;

/**
 * 错误种类
 */
@Getter
public enum ErrorEnum {
    ID_NOT_NULL("F001", "编号不可为空", false),
    UNKONW("999", "未知异常", false),
    ;

    private String code;

    private String message;

    private boolean canRetry;


    ErrorEnum(String code, String message, boolean canRetry) {
        this.code = code;
        this.message = message;
        this.canRetry = canRetry;
    }

    public static ErrorEnum getByCode(String code) {
        for (ErrorEnum errorEnum : ErrorEnum.values()) {
            if (code.equals(errorEnum.code)) {
                return errorEnum;
            }
        }
        return UNKONW;
    }
}
