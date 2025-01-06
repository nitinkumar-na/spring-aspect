package com.generalnitin.springaop.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("usage")
public class UsageProperties {
    String regularInvocationRequiredPeriod = "default";
}