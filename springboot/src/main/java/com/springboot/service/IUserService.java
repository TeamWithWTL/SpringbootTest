package com.springboot.service;

import java.util.List;

import com.springboot.entity.User;

public interface IUserService {
	/**
	 * 根据用户名获取用户名密码
	 * @param username 用户名
	 * @return	用户名密码
	 */
	User getUserByUsername(String username);
	
	/**
	 * 查询所有的用户信息
	 * @return
	 */
	List<User> getUser();
	
}
