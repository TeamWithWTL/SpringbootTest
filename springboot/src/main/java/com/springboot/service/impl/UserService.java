package com.springboot.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.User;
import com.springboot.mapper.UserMapper;
import com.springboot.service.IUserService;
import com.springboot.util.PublicUtil;

@Service("userService")
public class UserService implements IUserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired 
	private PublicUtil<User> publicUtil;
	
	public User getUserByUsername(String username) {
		User user = userMapper.getOneMessage("user", "username", username);
		return user;
	}

	@Override
	public List<User> getUser() {
		List<User> users = userMapper.getAllMessage("user");
		return users;
	}

	@Override
	public Integer addUser(User user) {
		String[] keyStrings = null;
		try {
			keyStrings = publicUtil.getKeyArray(publicUtil.values(user, User.class));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String[] valueStrings = publicUtil.getValueStrings(keyStrings);
		return userMapper.addOneMessage("user", user, keyStrings, valueStrings);
	}

	@Override
	public Integer updateUser(User user) {
		String[] keyStrings = null;
		try {
			keyStrings = publicUtil.getKeyArray(publicUtil.values(user, User.class));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String[] valueStrings = publicUtil.getValueStrings(keyStrings);
		return userMapper.updateOneMessage("user", user, keyStrings, valueStrings);
	}

	@Override
	public Integer deleteUser(Integer id) {
		return userMapper.deleteOneMessage("user", id);
	}


}
