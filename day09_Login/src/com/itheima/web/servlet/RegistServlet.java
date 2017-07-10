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
 * 用户注册
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		//1.封装数据
		//创建一个user,调用user.setXxx()一个个封装。不推荐
		//调用BeanUtils中的 populate(Obj bean, Map<>)对象，来封装
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			//2.调用userservice的 regist(user)方法  返回值：int
			int i =new UserService().regist(user);
			//3.判断Int的值，将信息请求转发到msgservlet
			if(i == 1){
				request.setAttribute("msg", "注册成功");
				//请求转发
				request.getRequestDispatcher("/msg").forward(request, response);
			}else{
				request.setAttribute("msg", "添加失败");
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
