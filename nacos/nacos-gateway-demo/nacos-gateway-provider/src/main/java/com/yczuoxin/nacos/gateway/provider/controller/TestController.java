package com.yczuoxin.nacos.gateway.provider.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "hello Nacos Discovery " + string;
    }

    @GetMapping(value = "/divide")
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return String.valueOf(a / b);
    }
}
