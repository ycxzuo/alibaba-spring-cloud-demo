package com.yczuoxin.sentinel.core.demo.init;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.yczuoxin.sentinel.core.demo.config.NacosConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InitNacosFlowConfig {

    @Autowired
    private NacosConfig config;

    //@PostConstruct
    public void init() throws Exception {
        try {
            String serverAddr = config.getServerAddr();
            String dataId = config.getFlowdataId();
            String group = config.getGroup();
            ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(serverAddr, group, dataId,
                    source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
            System.out.println(flowRuleDataSource.getProperty());
            FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}