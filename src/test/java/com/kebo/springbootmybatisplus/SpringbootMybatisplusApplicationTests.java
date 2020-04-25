package com.kebo.springbootmybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kebo.springbootmybatisplus.mapper.UserMapper;
import com.kebo.springbootmybatisplus.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int i = userMapper.insert(user);
        System.out.println(i);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("hh");
        user.setId(6L);
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    /** 两个人同时改一个数据
     * 悲观锁：串行划处理，当一个人在改数据的时候，另一个人不能做任何操作
     * 乐观锁：对数据做版本号，比如当时版本是1，第一个做的操作后版本是2，第二个操作完后发现版本号变成2
     * 所以他的操作失败
     */

    /**
     * @Description: 测试乐观锁失败场景
     * @Param: []
     * @return: void
     * @Author: kb
     * @Date: 2020/4/25
     * @Time: 21:55
     */
    @Test
    public void testOptimisticLockerFail() {
        User user = userMapper.selectById(1254045065702064130L);
        //版本号-1，导致版本号不一致，将会修改失败
        user.setVersion(user.getVersion() - 1);
        userMapper.updateById(user);
    }

    /**
     * @Description: 测试批量查询
     * @Param: []
     * @return: void
     * @Author: kb
     * @Date: 2020/4/25
     * @Time: 21:57
     */
    @Test
    public void testFindIds() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    /**
     * @Description: 通过map封装查询条件
     * @Param: []
     * @return: void
     * @Author: kb
     * @Date: 2020/4/25
     * @Time: 21:58
     * map中的key对应的是数据库中的列名。例如数据库user_id，
     * 实体类是userId，这时map的key需要填写user_id
     */
    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "kb");
        map.put("age", 20);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectPage() {
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    public void testSelectMapsPage() {
        Page<User> page = new Page<>(1, 5);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
        //注意：此行必须使用 mapIPage 获取记录列表，否则会有数据类型转换错误
        mapIPage.getRecords().forEach(System.out::println);
        System.out.println(page.getCurrent());
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }
}
