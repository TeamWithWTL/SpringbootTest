package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.ResponseResult;
import com.springboot.entity.User;
import com.springboot.service.impl.UserService;
//@RestController= @ResponseBody ＋ @Controller
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "getUserByUsername")
	public ResponseResult<User> getUserByUsername(String username){
		User user = userService.getUserByUsername(username);
		ResponseResult<User> rr = new ResponseResult<User>();
		rr.setData(user);
		return rr;
	}
}
