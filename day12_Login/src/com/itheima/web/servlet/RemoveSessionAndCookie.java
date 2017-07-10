package com.itheima.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * �û�����˳������session �� cookie
 */
public class RemoveSessionAndCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���session
		request.getSession().invalidate();
		// ���cookie,����һ��ͬ��cookie
		Cookie cookie = new Cookie("savename", "");
		// ������ͬ��·��
		cookie.setPath(request.getContextPath() + "/");
		// ����cookie����Чʱ��
		cookie.setMaxAge(0);
		// д�������
		response.addCookie(cookie);

		//request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
