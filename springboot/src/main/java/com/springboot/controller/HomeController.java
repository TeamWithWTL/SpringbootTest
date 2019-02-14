package com.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.ResponseResult;
import com.springboot.entity.TToken;
import com.springboot.entity.User;

@RestController
@RequestMapping("/index")
public class HomeController {

	@RequestMapping("/home")
	public ResponseResult<Map> home(@RequestBody TToken ttoken){
		System.out.println("home.Controller");
		//获取前端的数据
		String token = ttoken.getTokenStr();
		System.out.println("tokenStr:" + token);
		boolean check = false;
		if(token != null) {
			check = true;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		//将最终的boolean值返回给客户端
		map.put("check", check);
		ResponseResult<Map> rr = new ResponseResult<Map>();
		rr.setData(map);
		return rr;
	}
}
	