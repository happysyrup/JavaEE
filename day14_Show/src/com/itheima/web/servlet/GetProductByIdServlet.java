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
 * ͨ����Ʒid��ȡ��Ʒ
 */
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.���ñ���
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		
		//1.��ȡ��Ʒpid
		String pid = request.getParameter("pid");
		
		//ͨ��pid��ȡ����Ʒ������ֵproduct
		Product p = null;
		try {
			p = new ProductService().getProductById(pid);
		} catch (Exception e) {
			e.printStackTrace();
			w.println("��ȡ��Ʒ��Ϣʧ��");
		}
		
		
		//3.��product����request���У�����ת����edit.jsp
		request.setAttribute("bean", p);
		request.getRequestDispatcher("/edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
