package com.springboot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.springboot.entity.User;
@Mapper
public interface UserMapper {
	/**
	 * 根据用户名获取用户名密码
	 * @param username 用户名
	 * @return	用户名密码
	 */
	@Select("select username,password from user where username = #{username}")
	User getUserByUsername(String username);
	
	/**
	 * 查询所有的用户信息
	 * @return
	 */
	@Select("select * from user")
	List<User> getUser();
}
