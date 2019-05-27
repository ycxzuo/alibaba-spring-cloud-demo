package com.yczuoxin.nacos.config.demo.config;

import com.alibaba.nacos.api.config.listener.Listener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.alibaba.nacos.NacosConfigProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 监听配置文件更改的消息事件
 */
@Component
public class ChangeRunner implements ApplicationRunner {

    @Autowired
	private NacosConfigProperties nacosConfigProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        nacosConfigProperties.configServiceInstance().addListener("nacos-config-example.yaml",
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
                    }
                });
    }
}
