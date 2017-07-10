package com.itheima.a_response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loc2Servlet
 */
public class Loc2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("¸øÄã20¡£¡£");
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().print("¸øÄã20 £¡£¡");
		//response.setHeader("refresh", "1;url=http://www.baidu.com");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
