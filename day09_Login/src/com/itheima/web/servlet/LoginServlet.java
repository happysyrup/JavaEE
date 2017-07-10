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
		// 0.设置编码
		resp.setContentType("text/html;charset=utf-8");

		// 1.接收用户名和密码
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		// 2.调用userservice里的login(username,password)。返回值User user
		User user = null;
		try {
			user = new UserService().login(username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("网络错误");
		}
		// 3.判断user是否为空。
		if (user == null) {
			resp.getWriter().print("用户名或密码不匹配,3秒后跳转");
			resp.setHeader("refresh", "3;url=/day09_Login/login.htm");
		} else {
			resp.getWriter().print("欢迎你！" + user.getUsername());
		}
	}
}
