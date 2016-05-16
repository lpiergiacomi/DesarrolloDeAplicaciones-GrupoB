package ar.edu.unq.desapp.grupob.services;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.joda.time.DateTime;

@Aspect
public class LoggingAspect {

    @After("execution(* ar.edu.unq.desapp.grupob.services.GenericService.*(..))")
    public void logBefore(JoinPoint joinPoint) {

        System.out.println("===================================================================");
        System.out.println("===================================================================");
        System.out.println("At: " + new DateTime());
        System.out.println("In the class " + joinPoint.getSignature().getDeclaringType());
        System.out.println("The method " + joinPoint.getSignature().getName() + " was called");
        System.out.println("===================================================================");
        System.out.println("===================================================================");
    }
}