package ar.edu.unq.desapp.grupob.services;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.joda.time.DateTime;

@Aspect
public class LoggingAspect {

    public static Logger logger = Logger.getLogger(LoggingAspect.class);

    @After("execution(* ar.edu.unq.desapp.grupob.services.GenericService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("AT: " + new DateTime());
        logger.info("CLASS: " + joinPoint.getTarget().toString() +
                    " | METHOD: " + joinPoint.getSignature().getName() +
                    " | ARGUMENTS: " + printArguments(joinPoint.getArgs()));
    }

    private static String printArguments(Object[] anArgumentsArray) {
        Object[] arguments = anArgumentsArray;
        String output = "";
        for (Object argument: arguments) {
            output += argument;
        }
        return output;
    }
}