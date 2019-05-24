package com.yczuoxin.nacos.consumer.config;

import com.yczuoxin.nacos.consumer.service.EchoService;

public class EchoServiceFallback implements EchoService {

    @Override
    public String echo(String str) {
        return "echo fallback";
    }

    @Override
    public String divide(Integer a, Integer b) {
        return "divide fallback";
    }

    @Override
    public String notFound() {
        return "notFound fallback";
    }
}
