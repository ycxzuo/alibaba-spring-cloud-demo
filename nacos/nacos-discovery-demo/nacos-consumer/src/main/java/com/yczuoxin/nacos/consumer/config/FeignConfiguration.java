package com.yczuoxin.nacos.consumer.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    EchoServiceFallback echoServiceFallback(){
        return new EchoServiceFallback();
    }
}
