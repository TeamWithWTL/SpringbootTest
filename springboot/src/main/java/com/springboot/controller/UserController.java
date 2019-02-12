package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
		System.out.println("1");
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
		Integer row = userService.addUser(user);
		System.out.println("rows:"+row);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		return rr;
	}
	
	@RequestMapping("/update")
	public ResponseResult<Void> updateUser(@RequestBody User user){
		Integer row = userService.updateUser(user);
		System.out.println("rows:"+row);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		return rr;
	}
	
	@RequestMapping("/delete")
	public ResponseResult<Void> deleteUser(@RequestBody User user){
		Integer row = userService.deleteUser(user.getId());
		System.out.println("rows:"+row);
		ResponseResult<Void> rr = new ResponseResult<Void>();
		return rr;
	}
	
	@RequestMapping("/login")
	public ResponseResult<Void> login(@RequestBody User user,HttpSession session){
		System.out.println("login.Controller");
		User user1 = userService.login(user.getUsername(), user.getPassword());
		session.setAttribute("id", user1.getId());
		session.setAttribute("username", user1.getUsername());
		return new ResponseResult<Void>();
	}
}
