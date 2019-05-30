package com.yczuoxin.sentinel.core.demo.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 初始化规则
 */
@Configuration
public class InitFlowConfig {

    @PostConstruct
    public void initFlowQpsRule(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("hardOne");
        rule.setCount(2.0d);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp(RuleConstant.LIMIT_APP_DEFAULT);
        rules.add(rule);

        FlowRule rule2 = new FlowRule("hardTwo");
        rule2.setCount(1.0d);
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setLimitApp(RuleConstant.LIMIT_APP_DEFAULT);
        rules.add(rule2);
        FlowRuleManager.loadRules(rules);
    }
}
