package com.itheima.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;

/**
 * 通过条件查询商品信息
 */
public class FindProductByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.获取参数
		request.setCharacterEncoding("utf-8");
		
		//1.获取两个参数
		String name = request.getParameter("name");
		String kw = request.getParameter("kw");
		
		//2.调用service完成操作。返回值：list
		List<Product> plist = null;
		try {
			plist = new ProductService().findProductByCondition(name,kw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "查找信息失败~~");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
		//3.将list放入request域中，请求转发
		request.setAttribute("list", plist);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
