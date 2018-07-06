package com.springboot.exception;



/**
 * @Author: XieLiang
 * @Date : 2018/7/5
 * @Comment :
 */

public class GirlException extends RuntimeException {
    private Integer code;

    public GirlException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
