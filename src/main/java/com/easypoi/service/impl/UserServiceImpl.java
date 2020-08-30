package com.easypoi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easypoi.mapper.UserMapper;
import com.easypoi.domain.UserDomain;
import com.easypoi.service.UserService;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 * @author brb
 * @date 2020年08月30日
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDomain> implements UserService {
}
