package com.yczuoxin.springboot.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class TestController {

    @GetMapping("/hello")
    @SentinelResource(value = "resource", fallback = "fallback", blockHandler = "handlerException")
    public String hello(@RequestParam(value = "costTime", defaultValue = "10", required = false) Long costTime) throws InterruptedException {
        Thread.sleep(costTime);
        return "hello world";
    }

    public String handlerException(Long costTime, BlockException e){
        e.printStackTrace();
        log.error("request for hello exception happened");
        return "exception happened";
    }

    public String fallback(Long costTime){
        log.error("request for hello fallback");
        return "fallback";
    }

}
