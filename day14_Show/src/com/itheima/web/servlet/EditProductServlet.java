package com.itheima.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;

/**
 * 修改商品
 */
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("utf-8");
		
		//1.封装数据
		Product p = new Product();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			//2.调用service 完成更新
			new ProductService().updateProduct(p);
			
			//3.重定向到FindAllServlet
			response.sendRedirect(request.getContextPath()+"/findAll");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "修改商品信息出错~~~~");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
