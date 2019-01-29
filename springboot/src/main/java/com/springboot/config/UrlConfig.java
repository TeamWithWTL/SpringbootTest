package com.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *  用来解决跨域问题
 * @author luoji
 *
 */
@Configuration
public class UrlConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            	/*
            	 * allowedOrigins()里面写需要跨域的地址和端口号 
            	 * allowedMethods支持的http请求 
            	 * allowCredentials这个要设置成true才能实现跨域
            	 */
                registry.addMapping("/**").allowedOrigins("http://127.0.0.1:8010").allowedMethods("*").allowCredentials(true);
            }
        };
    }
}