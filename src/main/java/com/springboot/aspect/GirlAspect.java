package com.springboot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: XieLiang
 * @Date : 2018/7/5
 * @Comment :
 */
@Component
@Aspect
public class GirlAspect {
    private final static Logger logger = LoggerFactory.getLogger(GirlAspect.class);


    @Pointcut("execution(public * com.springboot.controllers.GirlController.*(..))")
    public void common(){
    }

    @Before("common()")
    public void doBefore(JoinPoint joinPoint){
        //获取请求
        ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",request.getMethod());
        logger.info("id={}",request.getRemoteAddr());
        logger.info("class-method={}",joinPoint.getSignature().getDeclaringTypeName());
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("common()")
    public void doAfter(){
        logger.info("doAfter");
    }

    @AfterReturning(returning = "object",pointcut = "common()")
    public void doAfterReturning(Object object){
        //logger.info("response={}",object.toString());
    }
}
