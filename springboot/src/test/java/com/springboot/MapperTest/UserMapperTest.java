package com.springboot.MapperTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
	UserMapper userMapper;
	@Test
	public void contextLoads() {
		String username = "admin";
		User user = userMapper.getOneMessage("user", "username", username);
		System.out.println(user.getUsername());
	}

}

