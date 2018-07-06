package com.springboot.enums;

/**
 * @Author: XieLiang
 * @Date : 2018/7/5
 * @Comment :
 */
public enum GirlEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    SO_SEXY(100,"还是很立挺的"),
    TOO_OLD(101,"可能已经下垂了"),
    ;
    private Integer code;
    private String message;

    GirlEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
