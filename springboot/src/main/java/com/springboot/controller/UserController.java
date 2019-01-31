package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping("/getUserByUsername")
	public ResponseResult<User> getUserByUsername(@RequestBody User user1) { //@RequestBody 用来接收接收json，会自动转换成对象，前端一定要传对应的格式
		String username = user1.getUsername();
		User user = userService.getUserByUsername(username);
		ResponseResult<User> rr = new ResponseResult<User>();
		rr.setData(user);
		return rr;
	}
	
	@RequestMapping("/getUser")
	public ResponseResult<List<User>> getUser(){
		List<User> users = userService.getUser();
		ResponseResult<List<User>> rr = new ResponseResult<List<User>>();
		rr.setData(users);
		return rr;
	}
	
	@RequestMapping("/add")
	public ResponseResult<Void> addUser(@RequestBody User user){
		System.out.println(user);
		userService.addUser(user);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		return rr;
	}
}
