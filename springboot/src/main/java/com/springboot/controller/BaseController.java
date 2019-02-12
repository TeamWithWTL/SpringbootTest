package com.springboot.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.entity.ResponseResult;
import com.springboot.service.ex.NullPointException;
import com.springboot.service.ex.PasswordErrorException;
import com.springboot.service.ex.ServiceException;

public abstract class BaseController {
	
	@ExceptionHandler(ServiceException.class)
	@ResponseBody
	private ResponseResult<Void> handleException(Exception e) {
		if(e instanceof NullPointException) {
			return new ResponseResult<Void>(101,e);
		}else if(e instanceof PasswordErrorException) {
			return new ResponseResult<Void>(102,e);
		}
		return new ResponseResult<Void>(666,e);
	}
}
