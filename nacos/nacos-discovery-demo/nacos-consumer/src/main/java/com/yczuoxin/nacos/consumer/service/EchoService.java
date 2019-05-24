package com.yczuoxin.nacos.consumer.service;

import com.yczuoxin.nacos.consumer.config.EchoServiceFallback;
import com.yczuoxin.nacos.consumer.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "nacos-provider", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface EchoService {

    @GetMapping(value = "/echo/{str}")
    String echo(@PathVariable("str") String str);

    @GetMapping(value = "/divide")
    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    @GetMapping(value = "/notFound")
    String notFound();
}
