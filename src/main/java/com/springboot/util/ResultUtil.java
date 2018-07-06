package com.springboot.util;

import com.springboot.beans.Result;

/**
 * @Author: XieLiang
 * @Date : 2018/7/5
 * @Comment :
 */

public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
}
