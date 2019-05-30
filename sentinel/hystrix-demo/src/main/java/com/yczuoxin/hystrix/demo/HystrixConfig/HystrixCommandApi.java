package com.yczuoxin.hystrix.demo.hystrixConfig;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

import java.util.concurrent.Callable;

public class HystrixCommandApi extends HystrixCommand<String> {
    private final String name;
    private final Callable<String> callable;

    public HystrixCommandApi(String name, Callable<String> callable) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"),50);
        this.name = name;
        this.callable = callable;
    }

    @Override
    protected String run() throws Exception {
        return callable.call();
    }

    @Override
    protected String getFallback() {
        return "Hello Failure " + name + "!";
    }
}
