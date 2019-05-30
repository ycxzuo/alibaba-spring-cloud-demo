package com.yczuoxin.hystrix.demo.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yczuoxin.hystrix.demo.hystrixconfig.HystrixCommandApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

;

/**
 * hystrix 会切换线程池，ThreadLocal 会出问题，如 Spring 的事务
 */
@RestController
public class TestController {

    @GetMapping("/hystrix/api")
    public String hystrixApi(@RequestParam(required = false, defaultValue = "10") int costTime){
        HystrixCommandApi hystrixCommand = new HystrixCommandApi("hystrix-api", () -> {
            Thread.sleep(costTime);
            System.out.printf("[%s] helloWorld costs time: %d\n", Thread.currentThread().getName(), costTime);
            return "Hystrix Api";
        });
        return hystrixCommand.execute();
    }

    @GetMapping("")
    @com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeInMilliseconds",
                             value = "50")
    }, fallbackMethod = "fallbackMethod")
    public String helloWorld(@RequestParam(required = false, defaultValue = "10") int costTime) throws InterruptedException {
        Thread.sleep(costTime);
        System.out.printf("[%s] helloWorld costs time: %d\n", Thread.currentThread().getName(), costTime);
        return "Hello World";
    }

    public String fallbackMethod(int costTime) {
        System.out.printf("[%s] fallbackMethod costs time: %d\n", Thread.currentThread().getName(), costTime);
        return "fallback - costTime: " + costTime + " ms";
    }
}
