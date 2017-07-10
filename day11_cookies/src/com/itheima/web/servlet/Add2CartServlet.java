package com.itheima.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��ӵ����ﳵ
 */
public class Add2CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.���ñ���
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();

		// 1.��ȡ��Ʒ������
		String name = request.getParameter("name");
		name = new String(name.getBytes("iso8859-1"), "utf-8");

		// 2.����Ʒ��ӵ����ﳵ
		// 2.1��Session�л�ȡ���ﳵ
		Map<String, Integer> map = (Map<String, Integer>) request.getSession().getAttribute("cart");
		Integer count = null;
		// 2.2�жϹ��ﳵ�Ƿ�Ϊ��
		if (map == null) {
			// ��һ�ι���������ﳵ
			map = new HashMap<>();

			// �����ﳵ����Session��
			request.getSession().setAttribute("cart", map);
			count = 1;
		} else {
			// ���ﳵ��Ϊ�գ������жϹ��ﳵ���Ƿ��и���Ʒ
			count = map.get(name);
			if (count == null) {
				// û�и���Ʒ
				count = 1;
			} else {
				// ���ﳵ���и���Ʒ
				count++;
			}
		}
		// ����Ʒ���빺�ﳵ
		map.put(name, count);

		// 3.��ʾ��Ϣ
		w.print("�ѽ�<b>" + name + "</b>���빺�ﳵ��<br><hr><br>");
		w.print("<a href='" + request.getContextPath() + "/product_list.jsp'>��������</a>&nbsp;&nbsp;&nbsp;");
		w.print("<a href='" + request.getContextPath() + "/cart.jsp'>�鿴���ﳵ</a>&nbsp;&nbsp;&nbsp;");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
