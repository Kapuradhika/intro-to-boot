package com.cognizant.introtoboot.home;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
final class HomeController {

    @GetMapping("/")
    String index(){
        return "Learning Spring Boot";
    }

    @GetMapping("/learn-spring-boot")
    String learn(){
        return "WTF";
    }

}
