package com.itheima.b_request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String value = req.getParameter("name");
		resp.setContentType("text/html;charset=utf-8");
		resp.getWriter().print("Êý¾Ý:"+value);
		System.out.println(value);
		
	}

}
