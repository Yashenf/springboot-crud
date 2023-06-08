package com.yashe.pos.HelloPos.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Value("${server.port}")
    int portNum;

    @Value("${spring.application.name}")
    String appNAme;

    @GetMapping("/access")
    public String access (){// http://localhost:8080/api/v1/test/access
       return appNAme+" is up and running on "+portNum;
    }
}
