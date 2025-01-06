package com.generalnitin.springaop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
@Configurable
@Component
public class LogAspect {

    // 1st: Before or After a method
//    @Before("execution(* com.generalnitin.springaop.services.HomeService.sayHello())")

    /// /    @Before("execution(* com.generalnitin.springaop.services.HomeService.*())")
    /// /    @Before("execution(* com.generalnitin.springaop.services.*.*())")
//    public void log() {
//        System.out.println("LogAspect.log()");
//    }

    // 2nd: Around, starting and ending of a method
//    @Around("execution(* com.generalnitin.springaop.services.HomeService.sayHello())")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Before LogAspect.log()");
//        Object result = joinPoint.proceed();
//        System.out.printf("Result of LogAspect.log(): %s\n", result);
//        System.out.println("After LogAspect.log()");
//        return result;
//    }

//    // 3rd: Named PointCut
//    @Pointcut("execution(* com.generalnitin.springaop.services.HomeService.sayHello())")
//    private void logPointcut() {
//    }
//
//    @Around("logPointcut()")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Before LogAspect.log()");
//        Object result = joinPoint.proceed();
//        System.out.printf("Result of LogAspect.log(): %s\n", result);
//        System.out.println("After LogAspect.log()");
//        return result;
//    }

    // 4th: within: All the methods within a class
//    @Around("within(com.generalnitin.springaop.services.HomeService)")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Before LogAspect.log()");
//        Object result = joinPoint.proceed();
//        System.out.printf("Result of LogAspect.log(): %s\n", result);
//        System.out.println("After LogAspect.log()");
//        return result;
//    }

    // 5th: @within: Applicable on all the annotations
//    @Around("@within(org.springframework.stereotype.Service)")
//    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Before LogAspect.log()");
//        Object result = joinPoint.proceed();
//        System.out.printf("Result of LogAspect.log(): %s\n", result);
//        System.out.println("After LogAspect.log()");
//        return result;
//    }

    // 6: custom annotation
    @Around("@annotation(CustomAnnotation)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        CustomAnnotation execTime = method.getAnnotation(CustomAnnotation.class);
        String metricName = execTime.metricName() != null ? execTime.metricName() : "method.timer";

        StopWatch stopWatch = new StopWatch();
        stopWatch.start(metricName);

        try {
            return joinPoint.proceed();
        }
        finally {
            stopWatch.stop();
            System.out.println(stopWatch.lastTaskInfo().getTaskName() +" "+ stopWatch.getTotalTime(TimeUnit.MILLISECONDS));
        }
    }

//    private final Logger logger =  LoggerFactory.getLogger(this.getClass());
//
//    @Around("@annotation(CustomAnnotation)")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object proceed = joinPoint.proceed();
//        long executionTime = System.currentTimeMillis() - startTime;
//        logger.info("Method {} executed in {} ms", joinPoint.getSignature().toShortString(), executionTime);
//        return proceed;
//    }
}
