package com.example.demo.suppress;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SuppressThrowsAspect {

    @Around(value = "@annotation(com.example.demo.suppress.SuppressThrows)")
    public Object around(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

        return null;
    }
}
