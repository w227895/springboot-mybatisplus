package com.kebo.springbootmybatisplus;

import com.kebo.springbootmybatisplus.mapper.UserMapper;
import com.kebo.springbootmybatisplus.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        List<User> userList = userMapper.selectList(null);
        System.out.println(userList);
    }

    /**
     * mp内部有一个主键生成策略
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setAge(20);
        user.setEmail("249183@qq.com");
        user.setName("kb");
        int i=userMapper.insert(user);
        System.out.println(i);
    }

}
