package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.User;
import com.itheima.service.UserService;

/**
 * �û�ע��
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.���ñ���
		request.setCharacterEncoding("utf-8");
		//1.��װ����
		//����һ��user,����user.setXxx()һ������װ�����Ƽ�
		//����BeanUtils�е� populate(Obj bean, Map<>)��������װ
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			//2.����userservice�� regist(user)����  ����ֵ��int
			int i =new UserService().regist(user);
			//3.�ж�Int��ֵ������Ϣ����ת����msgservlet
			if(i == 1){
				request.setAttribute("msg", "ע��ɹ�");
				//����ת��
				request.getRequestDispatcher("/msg").forward(request, response);
			}else{
				request.setAttribute("msg", "���ʧ��");
				request.getRequestDispatcher("/msg").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
