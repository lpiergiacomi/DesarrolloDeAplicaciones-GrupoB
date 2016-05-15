package ar.edu.unq.desapp.grupob.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LoggingAspect {

    @After("execution(* ar.edu.unq.desapp.grupob.services.GenericService.*(..)")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println("=====================HOLISSSSSSSSSSSSSSS  ================");
        System.out.println("==========================================================");
        System.out.println("==========================================================");
    }
}