package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.ProductService;

/**
 * 删除选中的商品
 */
public class DelCheckedProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取商品id
		String[] ids = request.getParameterValues("checked_pid");
		
		//2.调用service完成删除多个商品
		try {
			new ProductService().deleteManyProduct(ids);
		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "商品删除失败");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}
		
		//3.页面重定向
		response.sendRedirect(request.getContextPath()+"/findAll");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
