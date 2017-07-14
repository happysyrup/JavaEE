package com.itheima.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.ProductService;

/**
 * ɾ����Ʒ
 */
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();

		String pid = request.getParameter("pid");

		try {
			new ProductService().deleteProduct(pid);
			// w.print("ɾ���ɹ�");
			
			
			// ����ת��
			request.getRequestDispatcher("/findAll").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
			request.setAttribute("msg", "��Ʒɾ��ʧ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
			return;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
