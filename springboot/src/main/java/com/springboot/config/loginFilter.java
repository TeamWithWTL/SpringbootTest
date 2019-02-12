//package com.springboot.config;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
//public class loginFilter implements Filter {
//	
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		System.out.println("服务器初始化......");
//	}
//
//	@Override
//	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
//			throws IOException, ServletException {
//		System.out.println("服务器过滤中......");
//
//	}
//
//	@Override
//	public void destroy() {
//		System.out.println("服务器过滤结束");
//	}
//
//}
