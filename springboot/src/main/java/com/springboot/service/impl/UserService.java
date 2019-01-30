package com.springboot.service.impl;

import java.util.List;

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
		User user = userMapper.getOneMessage("user", "username", username);
		return user;
	}

	@Override
	public List<User> getUser() {
		List<User> users = userMapper.getAllMessage("user");
		return users;
	}

	
}
