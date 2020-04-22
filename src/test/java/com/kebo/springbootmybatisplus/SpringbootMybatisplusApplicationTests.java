package com.kebo.springbootmybatisplus;

import com.kebo.springbootmybatisplus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisplusApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testSelectList(){
		userMapper.selectList(null);
	}

}
