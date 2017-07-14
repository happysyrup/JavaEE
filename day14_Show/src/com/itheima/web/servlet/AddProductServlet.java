package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import com.itheima.utils.UUIDUtils;

/**
 * 添加商品
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0.设置编码
		request.setCharacterEncoding("utf-8");
		
		//1.封装数据
		Product p = new Product();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			//1.1设置pid
			p.setPid(UUIDUtils.getId());
			
			//1.2设置时间
			p.setPdate(new Date());
			
			//2.调用service完成添加操作
			new ProductService().addProduct(p);
			
			//3.页面跳转
			//先用请求转发
			//request.getRequestDispatcher("/findAll").forward(request, response);
			//重定向（解决重复提交问题）
			response.sendRedirect(request.getContextPath()+"/findAll");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "添加商品失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
