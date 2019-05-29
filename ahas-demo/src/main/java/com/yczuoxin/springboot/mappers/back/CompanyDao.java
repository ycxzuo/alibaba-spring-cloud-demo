package com.yczuoxin.springboot.mappers.back;

import com.yczuoxin.springboot.model.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDao {

    Company selectById(Long id);
}
