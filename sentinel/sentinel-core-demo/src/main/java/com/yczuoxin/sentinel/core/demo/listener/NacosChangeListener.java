package com.yczuoxin.sentinel.core.demo.listener;

import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.nacos.api.config.listener.Listener;
import com.yczuoxin.sentinel.core.demo.init.InitNacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.alibaba.nacos.NacosConfigProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

@Component
public class NacosChangeListener implements ApplicationRunner {

    @Autowired
	private NacosConfigProperties nacosConfigProperties;

    @Autowired
    InitNacosConfig config;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nacosConfigProperties.configServiceInstance().addListener("sentinel-nacos-demo.yaml",
                "DEFAULT_GROUP",
                new Listener() {
                    @Override
                    public Executor getExecutor() {
                        return null;
                    }
                    @Override
                    public void receiveConfigInfo(String configInfo) {
                        Properties properties = new Properties();
						try {
							properties.load(new StringReader(configInfo));
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("config changed: " + properties);
                        try {
                            config.init();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
