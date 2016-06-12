package ar.edu.unq.desapp.grupob.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Aspect 
@Order(1)
public class ErrorAspect {

    public static Logger logger = Logger.getLogger(ErrorAspect.class);

    @AfterThrowing(pointcut = "execution(* ar.edu.unq.desapp.grupob.services.GenericService.*(..))",throwing = "e")
    public void logAfter(JoinPoint joinPoint, Throwable e) {
        logger.error("EXCEPTION THROWN: " + e.toString() + 
                    " | AT CLASS: " + joinPoint.getTarget().toString());
        e.printStackTrace();
    }
}