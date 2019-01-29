package com.springboot.mapper;

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
	
}
