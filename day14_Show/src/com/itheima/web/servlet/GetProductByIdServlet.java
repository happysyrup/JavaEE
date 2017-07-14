package com.itheima.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.domain.Product;
import com.itheima.service.ProductService;

/**
 * 通过商品id获取商品
 */
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		
		//1.获取商品pid
		String pid = request.getParameter("pid");
		
		//通过pid获取到商品，返回值product
		Product p = null;
		try {
			p = new ProductService().getProductById(pid);
		} catch (Exception e) {
			e.printStackTrace();
			w.println("获取商品信息失败");
		}
		
		
		//3.将product放入request域中，请求转发到edit.jsp
		request.setAttribute("bean", p);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
