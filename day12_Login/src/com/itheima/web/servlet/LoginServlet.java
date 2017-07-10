package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.UserService;
import com.ithema.domain.User;

/**
 * 登录
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.设置编码
		request.setCharacterEncoding("utf-8");
		// 1.接收两个验证码
		String rcode = request.getParameter("checkcode");
		String scode = (String) request.getSession().getAttribute("sessionCode");
		// 一次性验证码，用完后从session中移除
		request.getSession().removeAttribute("sessionCode");
		// 判断两个验证码是否一致
		if (rcode == null || rcode.trim().length() == 0 || scode == null) {
			//验证码有问题，提示信息，页面跳转login.jsp
			request.setAttribute("msg", "请重新输入验证码");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(!rcode.equalsIgnoreCase(scode)){
			//验证码输入不一致，提示信息，页面跳转login.jsp
			request.setAttribute("msg", "验证码输入错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		// 2.接收用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 3.调用userservice的getUserByUsernameAndPwd() 返回值 user
		User user = null;
		try {
			user = new UserService().getUserByUsernameAndPwd(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 4.判断user
		if(user == null){
			// 4.1若user为空,提示信息，请求转发到login.jsp
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else{
			// 4.2若user不为空，判断是否勾选了记住用户名，将user放入session
			if("ok".equals(request.getParameter("savename"))){
				//创建cookie  username不能为中文
				Cookie cookie = new Cookie("savename", username);
				cookie.setPath(request.getContextPath()+"/");
				cookie.setMaxAge(3600);
				//写回浏览器
				response.addCookie(cookie);
			}
			//将user放入session
			request.getSession().setAttribute("username", user);
		}

		// 5.页面重定向index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
