package org.springframework.samples.petclinic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspect {
    @Pointcut("execution(* org.springframework.samples.petclinic.service.ClinicServiceImpl.*(..))")
    public void pointcut1() {}
    
    @Around("pointcut1()")
    //@Before("execution(* org.springframework.samples.petclinic.service.ClinicServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("================= POKUS3 ========");
        System.out.println(pjp);
        Object ret = pjp.proceed();
        return ret;
    }
}
