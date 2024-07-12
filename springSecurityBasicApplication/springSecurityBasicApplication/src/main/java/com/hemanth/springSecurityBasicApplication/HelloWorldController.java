package com.hemanth.springSecurityBasicApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/welcome")
    public String helloWorld(){
        return "Hi welcome to SpringBoot application  with security";
    }
}
