package com.yczuoxin.sentinel.core.demo.listener;

import com.alibaba.nacos.api.config.listener.Listener;
import com.yczuoxin.sentinel.core.demo.init.InitNacosDegradeConfig;
import com.yczuoxin.sentinel.core.demo.init.InitNacosFlowConfig;
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
    InitNacosFlowConfig flowConfig;

    @Autowired
    InitNacosDegradeConfig degradeConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nacosConfigProperties.configServiceInstance().addListener("sentinel-nacos-flow.yaml",
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
                            flowConfig.init();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
        nacosConfigProperties.configServiceInstance().addListener("sentinel-nacos-degrade.yaml",
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
                            degradeConfig.init();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
