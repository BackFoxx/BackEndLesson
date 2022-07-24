package com.example.expertspring30.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
public class MyAspect {
    @Before("execution(* com.example.expertspring30.aop.Person.runSomething())")
    public void before(JoinPoint joinPoint) {
        System.out.println("얼굴 인식 확인");
    }
}
