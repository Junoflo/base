package com.liuyibo.me.aspect;

import com.liuyibo.me.component.Conf;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author liuyibo
 * @Date 2019-03-26
 * @Desc
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Around("within(com.liuyibo.me.controller.*)")
    public Object controllerLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object result = "--";
        try {
            result = joinPoint.proceed();
            return result;
        } finally {
            Object[] args = joinPoint.getArgs();
            log(method, args, System.currentTimeMillis(), result);
        }
    }

    private void log(Method method, Object[] arguments, Long start, Object result) {
        log.info("method[{}.{}], params{}, result[{}], cost[{}]",
                method.getDeclaringClass().getSimpleName(),
                method.getName(), Conf.GSON.toJson(arguments), Conf.GSON.toJson(result),
                System.currentTimeMillis() - start);
    }

}
