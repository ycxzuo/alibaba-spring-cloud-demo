package com.yczuoxin.springboot.service.impl;

import com.yczuoxin.springboot.mappers.back.CompanyDao;
import com.yczuoxin.springboot.model.Company;
import com.yczuoxin.springboot.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyDao companyDao;

    @Override
    public Company getById(Long id) {
        return companyDao.selectById(id);
    }
}
