package com.yczuoxin.sentinel.core.demo.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

    @GetMapping("/api-hello")
    public String ApiHello(){
        try(Entry entry = SphU.entry("api")){
            return "API Hello";
        }catch (BlockException e){
            e.printStackTrace();
            System.out.println("exception");
            return "API Exception";
        }
    }
}
