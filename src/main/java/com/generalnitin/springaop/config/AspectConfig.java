package com.generalnitin.springaop.config;

import com.generalnitin.springaop.aspects.LogAspect;
import org.aspectj.lang.Aspects;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UsageProperties.class)
public class AspectConfig {
    @Bean
    LogAspect logAspect() {
        return Aspects.aspectOf(LogAspect.class);
    }
}
