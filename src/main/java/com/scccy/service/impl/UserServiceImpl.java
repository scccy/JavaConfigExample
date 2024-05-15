package com.scccy.service.impl;


import com.scccy.domain.User;
import com.scccy.mapper.UserMapper;
import com.scccy.service.UserService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }
}
