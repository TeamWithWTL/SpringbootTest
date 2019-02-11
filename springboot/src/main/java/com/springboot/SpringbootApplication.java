package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
/*
 * 创建项目引入Web/Web，SQL/MySQL，MyBatis组建
 */

@SpringBootApplication
//@MapperScan("com.springboot.mapper")指定扫描的mapper接口位置
@MapperScan("com.springboot.mapper")
//配置过滤器
@ServletComponentScan
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}