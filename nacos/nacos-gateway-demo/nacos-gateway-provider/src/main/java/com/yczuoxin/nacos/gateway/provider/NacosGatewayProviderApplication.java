package com.yczuoxin.nacos.gateway.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosGatewayProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosGatewayProviderApplication.class, args);
    }

}
