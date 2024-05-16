package com.scccy.aspect;

import com.scccy.common.ResultData;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class SqlReturnAspect {
    @Around("execution(* com.scccy.service.impl..*(..))")
    public Object checkInsertResult(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        try {
            Object result = joinPoint.proceed(args);
            if (result instanceof Integer) {
                Integer integer = (Integer) result;
                return integer > 0 ? ResultData.ok() : ResultData.fail();
            }
            return result; // 这里可以根据需要返回原始结果或其他封装的结果
        } catch (Exception e) {
            throw  e;
        }
    }
}

