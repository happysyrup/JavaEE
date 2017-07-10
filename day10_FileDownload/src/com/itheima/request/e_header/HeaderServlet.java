package com.itheima.request.e_header;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String header = request.getHeader("user-agent");
		System.out.println(header);
		String referer = request.getHeader("referer");
		if(referer==null){
			System.out.println("直接输入网址");
		}else if(referer.contains("localhost")){
			System.out.println("我自己点的");
		}else if(referer.contains("192.168")){
			System.out.println("别人点的");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
