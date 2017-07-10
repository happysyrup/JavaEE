package com.itheima.d_config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig  对象的常用方法
 */
public class SConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取servletconfig
		ServletConfig config = this.getServletConfig();
		//获取当前servlet的名称
		String servletName = config.getServletName();
		System.out.println("名称："+servletName);
		//获取初始化参数
		String user = config.getInitParameter("user");
		System.out.println("获取单一的值："+user);
		
		System.out.println("------------------------");
		
		//获取所有的参数名称
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println("参数名称"+name);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
