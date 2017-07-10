package com.itheima.a_response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 重定向
 */
public class Loc1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("没零钱。。。");
		System.out.println("又说：找侯老师。");
		//方式1，了解
		//response.setStatus(302);
		//response.setHeader("location", "/day10_FileDownload/loc2");
		
		//方式2 ，掌握
		response.sendRedirect("/day10_FileDownload/loc2");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
