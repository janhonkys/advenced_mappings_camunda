package com.luv2code.springboot.cruddemo.atest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/login")
    public String sayName() {
        return "sayname";
    }

}
