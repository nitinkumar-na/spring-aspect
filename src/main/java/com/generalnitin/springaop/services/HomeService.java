package com.generalnitin.springaop.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HomeService {

    public String sayHello() {
        return "Hello World!";
    }
}
