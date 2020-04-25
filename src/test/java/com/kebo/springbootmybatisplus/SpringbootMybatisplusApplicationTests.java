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

    @Test
    public void testUpdate(){
        User user=new User();
        user.setName("hh");
        user.setId(6L);
        int i=userMapper.updateById(user);
        System.out.println(i);
    }

    /** 两个人同时改一个数据
     * 悲观锁：串行划处理，当一个人在改数据的时候，另一个人不能做任何操作
     * 乐观锁：对数据做版本号，比如当时版本是1，第一个做的操作后版本是2，第二个操作完后发现版本号变成2
     * 所以他的操作失败
     */

    @Test
    public void testOptimisticLockerFail(){
        User user=userMapper.selectById(1254045065702064130L);
        user.setVersion(user.getVersion()-1);
        userMapper.updateById(user);
    }
}
