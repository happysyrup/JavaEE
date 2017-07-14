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
 * �����Ʒ
 */
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0.���ñ���
		request.setCharacterEncoding("utf-8");
		
		//1.��װ����
		Product p = new Product();
		try {
			BeanUtils.populate(p, request.getParameterMap());
			//1.1����pid
			p.setPid(UUIDUtils.getId());
			
			//1.2����ʱ��
			p.setPdate(new Date());
			
			//2.����service�����Ӳ���
			new ProductService().addProduct(p);
			
			//3.ҳ����ת
			//��������ת��
			//request.getRequestDispatcher("/findAll").forward(request, response);
			//�ض��򣨽���ظ��ύ���⣩
			response.sendRedirect(request.getContextPath()+"/findAll");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "�����Ʒʧ��");
			request.getRequestDispatcher("/msg.jsp").forward(request, response);
		} 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
