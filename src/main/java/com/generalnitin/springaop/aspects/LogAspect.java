package com.generalnitin.springaop.aspects;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Aspect
//@Configurable
@Component
@EnableTransactionManagement(mode = AdviceMode.ASPECTJ)
//@Slf4j
public class LogAspect {

    private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

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

    @PostConstruct
    public void init() {
        log.error("Initializing LogAspect");
    }
}
