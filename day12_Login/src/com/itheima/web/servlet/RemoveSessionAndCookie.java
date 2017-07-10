package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户点击退出，清空session 和 cookie
 */
public class RemoveSessionAndCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 清空session
		request.getSession().invalidate();
		// 清空cookie,创建一个同名cookie
		Cookie cookie = new Cookie("savename", "");
		// 设置相同的路径
		cookie.setPath(request.getContextPath() + "/");
		// 设置cookie的有效时间
		cookie.setMaxAge(0);
		// 写回浏览器
		response.addCookie(cookie);

		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
