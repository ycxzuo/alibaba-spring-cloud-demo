package com.yczuoxin.springboot.mappers.primary;

import com.yczuoxin.springboot.model.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {

    User selectById(Long id);
}
