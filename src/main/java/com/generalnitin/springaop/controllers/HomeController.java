package com.generalnitin.springaop.controllers;

import com.generalnitin.springaop.aspects.CustomAnnotation;
import com.generalnitin.springaop.services.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping()
//    @CustomAnnotation(metricName = "controller")
    public String hello() {
        return homeService.sayHello();
    }
}
