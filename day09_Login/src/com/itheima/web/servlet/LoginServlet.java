package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.User;
import com.itheima.service.UserService;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 0.���ñ���
		resp.setContentType("text/html;charset=utf-8");

		// 1.�����û���������
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 2.����userservice���login(username,password)������ֵUser user
		User user = null;
		try {
			user = new UserService().login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("�������");
		}
		// 3.�ж�user�Ƿ�Ϊ�ա�
		if (user == null) {
			resp.getWriter().print("�û��������벻ƥ��,3�����ת");
			resp.setHeader("refresh", "3;url=/day09_Login/login.htm");
		} else {
			resp.getWriter().print("��ӭ�㣡" + user.getUsername());
		}
	}
}
