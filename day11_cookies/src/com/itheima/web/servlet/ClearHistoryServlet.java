package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 清除浏览记录
 */
public class ClearHistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个同名cookie
		Cookie c = new Cookie("ids", "");
		//设置相同的路径
		c.setPath(request.getContextPath()+"/");
		//设置cookie的有效时间
		c.setMaxAge(0);
		//写回浏览器
		response.addCookie(c);
		//页面跳转
		response.sendRedirect(request.getContextPath()+"/product_list.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
