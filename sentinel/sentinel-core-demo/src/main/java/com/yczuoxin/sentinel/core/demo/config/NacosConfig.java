package com.yczuoxin.sentinel.core.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "nacos")
public class NacosConfig {
    private String serverAddr;
    private String flowdataId;
    private String degradedataId;
    private String group;

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public String getFlowdataId() {
        return flowdataId;
    }

    public void setFlowdataId(String flowdataId) {
        this.flowdataId = flowdataId;
    }

    public String getDegradedataId() {
        return degradedataId;
    }

    public void setDegradedataId(String degradedataId) {
        this.degradedataId = degradedataId;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
