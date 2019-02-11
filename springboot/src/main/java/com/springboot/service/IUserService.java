package com.springboot.service;

import java.util.List;

import com.springboot.entity.User;

public interface IUserService {
	/**
	 * 	根据用户名获取用户名密码
	 * @param username 用户名
	 * @return	用户名密码
	 */
	User getUserByUsername(String username);
	
	/**
	 * 	查询所有的用户信息
	 * @return	返回查询结果
	 */
	List<User> getUser();
	
	/**
	 * 	添加一条数据
	 * @param user	需要插入的数据
	 * @return	成功返回1，失败返回0
	 */
	Integer addUser(User user);
	
	/**
	 * 	修改一条信息
	 * @param user	需要存储的对象
	 * @return	成功返回1，失败返回0
	 */
	Integer updateUser(User user);
	
	/**
	 * 	删除一条信息
	 * @param id	信息id
	 * @return	成功返回1，失败返回0
	 */
	Integer deleteUser(Integer id);
}
