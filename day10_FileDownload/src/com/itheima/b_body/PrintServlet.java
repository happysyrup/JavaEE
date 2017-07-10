package com.itheima.b_body;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PrintServlet
 */
public class PrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html;charset=utf-8");
		response.setHeader("content-type", "text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter();
		pw.print("<table border='1'><tr>");
		pw.print("<td>姓名：</td><td>张三</td>");
		pw.print("<td>李四</td><td>王五</td></tr>");
		pw.print("<tr><td>密码：</td>");
		pw.print("<td>123</td><td>234</td><td>345</td>");
		pw.print("</tr></table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
