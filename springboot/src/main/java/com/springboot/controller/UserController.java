package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.ResponseResult;
import com.springboot.entity.User;
import com.springboot.service.impl.UserService;

//@RestController= @ResponseBody ＋ @Controller
@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = { "http://127.0.0.1:8010", "null" }) 如果不需要全局配置可以使用这个配置实现跨域
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "getUserByUsername")
	public ResponseResult<User> getUserByUsername(String username) {
		User user = userService.getUserByUsername(username);
		ResponseResult<User> rr = new ResponseResult<User>();
		rr.setData(user);
		return rr;
	}
}
