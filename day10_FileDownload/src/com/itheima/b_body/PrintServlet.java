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
		pw.print("<td>������</td><td>����</td>");
		pw.print("<td>����</td><td>����</td></tr>");
		pw.print("<tr><td>���룺</td>");
		pw.print("<td>123</td><td>234</td><td>345</td>");
		pw.print("</tr></table>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
