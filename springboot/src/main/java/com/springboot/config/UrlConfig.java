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
                registry
                .addMapping("/**")
                //allowedOrigins()里面写需要跨域的地址和端口号 
                .allowedOrigins("http://127.0.0.1:8010")
                //allowedMethods支持的http请求
                .allowedMethods("*")
                //allowCredentials这个要设置成true才能实现跨域
                .allowCredentials(true);//.maxAge(3600);
                //放行哪些原始域(头部信息)
                //.allowedHeaders("*")
                //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                //.exposedHeaders("token");
            }
        };
    }
}