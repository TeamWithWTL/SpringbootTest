package com.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.IUserService;

@Service("userService")
public class UserService implements IUserService{
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByUsername(String username) {
		System.out.println("userService.getUserByUsername");
		User user = userMapper.getUserByUsername(username);
		return user;
	}

	
}
