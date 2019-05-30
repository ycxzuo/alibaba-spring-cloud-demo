package com.yczuoxin.sentinel.core.demo;

import com.yczuoxin.sentinel.core.demo.init.InitNacosConfig;

public class Test {
    public static void main(String[] args) throws Exception {
        InitNacosConfig config = new InitNacosConfig();
        config.init();
    }
}
