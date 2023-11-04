package com.exia.aop.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class HelloWorldAOP {
    @Pointcut("execution(public * com.exia.aop.service..*(..))")
    public void pointcut(){

    }

    @Before(value = "pointcut()")
    public void before(JoinPoint point) {
        String className = point.getTarget().getClass().getSimpleName();
        String methodName = point.getSignature().getName();
        log.info("Aspect - before invoking {}.{}", className, methodName);
    }

    @AfterReturning(value = "pointcut()", returning = "result")
    public void afterReturn(JoinPoint point, Object result) {
        if (result != null) {
            log.info("Aspect - after result: {}", result);
        } else {
            log.info("Aspect - after result: null");
        }
    }
}
