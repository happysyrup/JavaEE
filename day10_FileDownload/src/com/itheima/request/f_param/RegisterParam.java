package com.itheima.request.f_param;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterParam
 */
public class RegisterParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");//Ωˆœﬁpost«Î«Û±‡¬Î
		response.setContentType("text/html;charset=utf-8");
		
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		System.out.println("name:"+name);
		System.out.println("pwd:"+pwd);
		
		PrintWriter pw = response.getWriter();
		pw.println("name:"+name);
		pw.println("pwd:"+pwd);
	}

}
