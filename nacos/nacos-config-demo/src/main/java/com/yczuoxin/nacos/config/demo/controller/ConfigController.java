package com.yczuoxin.nacos.config.demo.controller;

import com.yczuoxin.nacos.config.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    /**
     * url：http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=nacos-config-example.yaml&group=DEFAULT_GROUP&content=person.id: 2
     */
    @Autowired
    private Person person;

    /**
     * http://127.0.0.1:8848/nacos/v1/cs/configs?dataId=nacos-config-example.yaml&group=DEFAULT_GROUP&content=useLocalCache: true
     */
    @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @GetMapping("/get")
    public boolean get(){
        return useLocalCache;
    }

    @GetMapping("/person")
    public Person getPerson(){
        return person;
    }

}
