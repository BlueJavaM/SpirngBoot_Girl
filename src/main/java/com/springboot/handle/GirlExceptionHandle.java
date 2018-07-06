package com.springboot.handle;

import com.springboot.beans.Result;
import com.springboot.exception.GirlException;
import com.springboot.util.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: XieLiang
 * @Date : 2018/7/5
 * @Comment :
 */
@ControllerAdvice
public class GirlExceptionHandle {
    @ExceptionHandler(value = GirlException.class)
    @ResponseBody
    public Result girlHandle(GirlException e){
        if (e instanceof GirlException){
            GirlException girlException = e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }
        return ResultUtil.error(-1,"未知错误");
    }
}
