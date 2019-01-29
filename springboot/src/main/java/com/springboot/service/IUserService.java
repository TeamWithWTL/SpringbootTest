package com.springboot.service;

import com.springboot.entity.User;

public interface IUserService {
	/**
	 * 根据用户名获取用户名密码
	 * @param username 用户名
	 * @return	用户名密码
	 */
	User getUserByUsername(String username);
}
