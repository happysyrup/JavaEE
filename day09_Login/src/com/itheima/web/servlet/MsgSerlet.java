package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MsgSerlet
 */
public class MsgSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		//1.从request域中获取msg内容
		String message = (String) request.getAttribute("msg");
		//2.将信息打印到页面上
		response.getWriter().println(message);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
