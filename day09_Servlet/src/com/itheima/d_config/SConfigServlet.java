package com.itheima.d_config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ServletConfig  ����ĳ��÷���
 */
public class SConfigServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.��ȡservletconfig
		ServletConfig config = this.getServletConfig();
		//��ȡ��ǰservlet������
		String servletName = config.getServletName();
		System.out.println("���ƣ�"+servletName);
		//��ȡ��ʼ������
		String user = config.getInitParameter("user");
		System.out.println("��ȡ��һ��ֵ��"+user);
		
		System.out.println("------------------------");
		
		//��ȡ���еĲ�������
		Enumeration<String> names = config.getInitParameterNames();
		while(names.hasMoreElements()){
			String name = names.nextElement();
			System.out.println("��������"+name);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}