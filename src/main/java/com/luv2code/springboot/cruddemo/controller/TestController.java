package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entityDto.Test;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @GetMapping("/test")
    public Test test() {

        Test test = new Test(1, "Pavel", "Novák");
        System.out.println(test.getId());
        System.out.println(test.getName());
        System.out.println(test.getLastName());
        log.warn("Warn");
        log.debug("Debug");
        log.error("Debug");
        log.info("Info");
        log.trace("Trace");

        Test a = new Test();
        System.out.println(a.hashCode());
        System.out.println("A test " +a.equals(test));
        System.out.println(a);
        System.out.println(a.toString());

        return test;

    }

    @GetMapping("/test2/{street}")
    public String test(@PathVariable String street) {
        return street;
    }

    @GetMapping("test1")
    public void test1() {
        Test t = new Test(10, "Pavel", "Novák");
        System.out.println(t.toString());
    }

}
