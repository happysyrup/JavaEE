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
 * ��¼
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.���ñ���
		request.setCharacterEncoding("utf-8");
		// 1.����������֤��
		String rcode = request.getParameter("checkcode");
		String scode = (String) request.getSession().getAttribute("sessionCode");
		// һ������֤�룬������session���Ƴ�
		request.getSession().removeAttribute("sessionCode");
		// �ж�������֤���Ƿ�һ��
		if (rcode == null || rcode.trim().length() == 0 || scode == null) {
			//��֤�������⣬��ʾ��Ϣ��ҳ����תlogin.jsp
			request.setAttribute("msg", "������������֤��");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if(!rcode.equalsIgnoreCase(scode)){
			//��֤�����벻һ�£���ʾ��Ϣ��ҳ����תlogin.jsp
			request.setAttribute("msg", "��֤���������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}

		// 2.�����û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 3.����userservice��getUserByUsernameAndPwd() ����ֵ user
		User user = null;
		try {
			user = new UserService().getUserByUsernameAndPwd(username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 4.�ж�user
		if(user == null){
			// 4.1��userΪ��,��ʾ��Ϣ������ת����login.jsp
			request.setAttribute("msg", "�û������������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}else{
			// 4.2��user��Ϊ�գ��ж��Ƿ�ѡ�˼�ס�û�������user����session
			if("ok".equals(request.getParameter("savename"))){
				//����cookie  username����Ϊ����
				Cookie cookie = new Cookie("savename", username);
				cookie.setPath(request.getContextPath()+"/");
				cookie.setMaxAge(3600);
				//д�������
				response.addCookie(cookie);
			}
			//��user����session
			request.getSession().setAttribute("username", user);
		}

		// 5.ҳ���ض���index.jsp
		response.sendRedirect(request.getContextPath()+"/index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
