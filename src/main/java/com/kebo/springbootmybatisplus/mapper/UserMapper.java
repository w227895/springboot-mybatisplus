package com.kebo.springbootmybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kebo.springbootmybatisplus.po.User;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: kb
 * @create: 2020-04-22 21:35
 **/
@Component
public interface UserMapper extends BaseMapper<User> {
}

