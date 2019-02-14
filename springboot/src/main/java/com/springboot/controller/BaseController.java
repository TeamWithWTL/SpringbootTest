package com.springboot.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.entity.ResponseResult;
import com.springboot.service.ex.NullPointException;
import com.springboot.service.ex.PasswordErrorException;
import com.springboot.service.ex.ServiceException;
import com.springboot.service.ex.UsernameErrorException;
@ControllerAdvice
public abstract class BaseController {
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	private ResponseResult<Void> handleException(Exception e) {
		if(e instanceof PasswordErrorException) {
			//密码错误
			return new ResponseResult<Void>(101,e);
		}else if(e instanceof UsernameErrorException) {
			//用户名错误
			return new ResponseResult<Void>(102,e);
		}
		//其他
		return new ResponseResult<Void>(666,e);
	}
}
