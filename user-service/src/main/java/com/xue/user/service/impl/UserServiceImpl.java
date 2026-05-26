package com.xue.user.service.impl;

import com.xue.user.mapper.UserMapper;
import com.xue.user.pojo.User;
import com.xue.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
// 用户服务实现类
public class UserServiceImpl implements UserService {

    @Autowired
    // 注入用户数据访问层
    private UserMapper userMapper;

    @Override
    // 根据ID查询用户
    public User queryById(Long id) {
        User user = userMapper.findById(id);
        return user;
    }
}
