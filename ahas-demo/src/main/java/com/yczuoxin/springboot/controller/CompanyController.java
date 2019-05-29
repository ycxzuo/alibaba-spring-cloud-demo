package com.yczuoxin.springboot.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.yczuoxin.springboot.model.Company;
import com.yczuoxin.springboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping(value = "/company/{id}")
    @SentinelResource(value = "company-resource")
    public Company getById(@PathVariable("id") Long id) {
        return companyService.getById(id);
    }
}
