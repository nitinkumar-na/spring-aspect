package com.generalnitin.springaop.config;

import com.generalnitin.springaop.aspects.CustomAnnotation;
import org.aspectj.lang.Aspects;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UsageProperties.class)
public class AspectConfig {
//    @Bean
    CustomAnnotation customAnnotation() {
        return Aspects.aspectOf(CustomAnnotation.class);
    }
}
