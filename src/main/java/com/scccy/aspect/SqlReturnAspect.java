package com.scccy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class SqlReturnAspect {
    @Around("execution(* com.scccy.service.impl..*(..))")
    public Boolean checkInsertResult(ProceedingJoinPoint joinPoint) throws Throwable {
        // 通过ProceedingJoinPoint对象获取外界调用目标方法时传入的实参数组
        Object[] args = joinPoint.getArgs();
        // 声明变量用来存储目标方法的返回值
        Object targetMethodReturnValue = null;
        try {
            // 过ProceedingJoinPoint对象调用目标方法
            // 目标方法的返回值一定要返回给外界调用者
            targetMethodReturnValue = joinPoint.proceed(args);
            if(targetMethodReturnValue instanceof Integer integer) {
                if(integer > 0) return true;
            }else {
                return false;
            }
        } catch (Throwable e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
