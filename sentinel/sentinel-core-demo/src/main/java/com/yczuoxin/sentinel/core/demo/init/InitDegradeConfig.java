package com.yczuoxin.sentinel.core.demo.init;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化降级规则
 */
@Configuration
public class InitDegradeConfig {

    /**
     * 已经被 nacos 的 listener 取代初始化
     *
     * sentinel-nacos-degrade.yaml
     * DEFAULT_GROUP
     * [
     *   {
     *     "resource": "hardThree",
     *     "count": 10,
     *     "timeWindow": 10,
     *     "grade": 0,
     *     "limitApp": "default",
     *     "strategy": 0
     *   }
     * ]
     */
    //@PostConstruct
    private void initDegradeRule() {
    List<DegradeRule> rules = new ArrayList<>();
    DegradeRule rule = new DegradeRule();
    rule.setResource("hardThree");
    // set threshold RT, 10 ms
    rule.setCount(10);
    rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
    // 10s
    rule.setTimeWindow(10);
    rules.add(rule);
    DegradeRuleManager.loadRules(rules);
}
}
