package com.springboot.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//前端路由控制路径，后端过滤器现在暂时用不到
@WebFilter(filterName = "sessionFilter",urlPatterns = {"/*"})
public class loginFilter implements Filter {

	private List<String> permit;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("服务器初始化......");
		permit = new ArrayList<String>();
		permit.add("login");
		System.out.println("允许直接访问的路径有：");
		System.out.println(permit);
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("服务器过滤中......");
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response =(HttpServletResponse) arg1;
		chain.doFilter(arg0, arg1);
//		String url = request.getRequestURI();
//		String[] urls = url.split("/");
//		String path = urls[urls.length-1];
//		System.out.println("PATH:" + path);
//		if(permit.contains(path)) {
//			chain.doFilter(arg0, arg1);
//			return;
//		}
//		HttpSession session = request.getSession();
//		System.out.println("session:" + session.getAttribute("username"));
//		if(session.getAttribute("username") != null) {
//			System.out.println("session:" + session.getAttribute("username"));
//			chain.doFilter(arg0, arg1);
//		}else {
//			String redirectPath = "http://127.0.0.1:8010/#/";
//			System.out.println("未登录，重定向到：" + redirectPath);
//			response.sendRedirect(redirectPath);
//		}
	}

	@Override
	public void destroy() {
		System.out.println("服务器过滤结束");
	}

}
