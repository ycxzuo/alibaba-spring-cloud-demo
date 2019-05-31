package com.yczuoxin.sentinel.core.demo.init;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化流控规则
 */
@Configuration
public class InitFlowConfig {

    /**
     * 已经被 nacos 的 listener 取代初始化
     *
     * sentinel-nacos-flow.yaml
     * DEFAULT_GROUP
     * [
     *   {
     *     "resource": "hello",
     *     "controlBehavior": 0,
     *     "count": 3.0,
     *     "grade": 1,
     *     "limitApp": "default",
     *     "strategy": 0
     *   },
     *   {
     *     "resource": "hardOne",
     *     "controlBehavior": 0,
     *     "count": 4.0,
     *     "grade": 1,
     *     "limitApp": "default",
     *     "strategy": 0
     *   },
     *   {
     *     "resource": "hardTwo",
     *     "controlBehavior": 0,
     *     "count": 5.0,
     *     "grade": 1,
     *     "limitApp": "default",
     *     "strategy": 0
     *   }
     * ]
     */
    //@PostConstruct
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
