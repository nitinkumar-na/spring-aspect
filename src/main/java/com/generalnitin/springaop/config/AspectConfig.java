package com.generalnitin.springaop.config;

import com.generalnitin.springaop.aspects.LogAspect;
import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AspectConfig {
    @Bean
    LogAspect logAspect() {
        if (Aspects.hasAspect(LogAspect.class)) {
            return Aspects.aspectOf(LogAspect.class);
        } else {
            return new LogAspect();
        }
    }
}
