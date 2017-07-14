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
 * ͨ��������ѯ��Ʒ��Ϣ
 */
public class FindProductByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.��ȡ����
		request.setCharacterEncoding("utf-8");
		
		//1.��ȡ��������
		String name = request.getParameter("name");
		String kw = request.getParameter("kw");
		
		//2.����service��ɲ���������ֵ��list
		List<Product> plist = null;
		try {
			plist = new ProductService().findProductByCondition(name,kw);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("msg", "������Ϣʧ��~~");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		}
		
		//3.��list����request���У�����ת��
		request.setAttribute("list", plist);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
