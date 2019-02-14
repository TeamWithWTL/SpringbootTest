package com.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.config.JwtToken;
import com.springboot.entity.ResponseResult;
import com.springboot.entity.User;
import com.springboot.service.impl.UserService;

//@RestController= @ResponseBody ＋ @Controller
@RestController
@RequestMapping("/user")
//@CrossOrigin(origins = { "http://127.0.0.1:8010"},allowCredentials = "true") //如果不需要全局配置可以使用这个配置实现跨域
public class UserController extends BaseController{
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
	public ResponseResult<Map> login(@RequestBody User user){
		System.out.println("login.Controller");
		System.out.println("username：" + user.getUsername());
		System.out.println("password：" + user.getPassword());
		//System.out.println("验证账号密码");
		User user1 = userService.login(user.getUsername(), user.getPassword());
		//System.out.println("验证账号密码结束");
		//token加密方法
		String token = JwtToken.hmac256();
		//走到这里返回一个true，不加也一样用
		boolean login = true;
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("login", login);
		map.put("token", token);
		ResponseResult<Map> rr = new ResponseResult<Map>();
		rr.setData(map);
		return rr;
	}
}
