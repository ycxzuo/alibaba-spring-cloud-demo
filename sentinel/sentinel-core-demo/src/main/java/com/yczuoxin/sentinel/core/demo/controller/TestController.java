package com.yczuoxin.sentinel.core.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * SentinelResource 标志资源是否被限流或者降级，hello表示资源名称
     *      entryType
     *      blockHandler/blockHandlerClass 处理 BlockException 的函数名，
     *          返回值类型要一样，参数要加一个入参 BlockException，如果需要使用其他类的函数，
     *          则 blockHandlerClass 指定类的 class 对象（必须是 static）
     *      fallback    抛出异常后的 fallback 逻辑处理
     *          返回值类型与原函数返回值一直
     *          方法参数列表需要和原函数一致，可以多一个 Throwable 类型参数解释异常
     *          fallback 函数默认需要和原方法在同一个类中，否则需要指定 fallbackClass 对应
     *          的 class 对象（必须是 static）
     *      defaultFallback
     */
    @GetMapping(value = "/hello")
    @SentinelResource(value = "hello", blockHandler = "exceptionHandler",fallback = "fallback")
    public String hello(@RequestParam(value = "costTime", required = false, defaultValue = "10") Long costTime) throws InterruptedException {
        Thread.sleep(costTime);
        System.out.printf("[%s] helloWorld costs time: %d\n", Thread.currentThread().getName(), costTime);
        return "Hello world";
    }

    public String exceptionHandler(Long costTime, DegradeException ex){
        ex.printStackTrace();
        System.out.printf("[%s] helloWorld costs time: %d\n", Thread.currentThread().getName(), costTime);
        return "exception happened";
    }

    public String fallback(Long costTime){
        System.out.printf("[%s] helloWorld costs time: %d\n", Thread.currentThread().getName(), costTime);
        return "fallback";
    }

}
