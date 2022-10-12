package fr.aelion.agedi.springdemo.aspects;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Log
@Aspect
@Component
public class LogAspect {

    @AfterReturning("execution(public * fr.aelion.agedi.springdemo.person.controllers.*Controller.*(..))")
    public void logAfterReturning() {
        log.info("aspect method after return");
    }

    @AfterThrowing("execution(public * fr.aelion.agedi.springdemo.person.controllers.*Controller.*(..))")
    public void logThrow() {
        log.info("aspect method was called after throw");
    }

    @Before("execution(public * fr.aelion.agedi.springdemo.person.controllers.*Controller.*(..))")
    public void logBefore() {
        log.info("aspect method was called before");
    }

}
