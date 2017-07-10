package com.itheima.web.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.utils.CookieUtil;

/**
 * ��¼��Ʒ�����¼
 */
public class GetProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 0.���ñ���
		response.setCharacterEncoding("utf-8");
		// ��ȡ��ǰ���ʵ�id
		String id = request.getParameter("id");
		// 1.��ȡָ����cookie ��Ϊids
		Cookie c = CookieUtil.getCookieByName("ids", request.getCookies());

		String ids = "";
		// 2.�ж�cookie�Ƿ�Ϊ��
		if (c == null) {
			// ��cookieΪ�գ���Ҫ����ǰ��Ʒid����ids��
			ids = id;
		} else {
			// ��cookie��Ϊ�գ������ж�ids���Ƿ��Ѿ�������id //ids=2-11-21
			// ��ȡֵ
			ids = c.getValue();
			String[] arr = ids.split("-");
			// ������ת�ɼ��� ��list���Ȳ��ɱ�
			List<String> asList = Arrays.asList(arr);
			// ��aslist����һ����list��
			LinkedList<String> list = new LinkedList<>(asList);
			if (list.contains(id)) {
				// ��ids�а���id ��id�Ƴ� �ŵ����
				list.remove(id);
				list.addFirst(id);
			} else {
				// ��ids�в�����id �����жϳ����Ƿ����2
				if (list.size() > 2) {
					// ����>=3�Ƴ����һ�� ����ǰ�ķŵ���ǰ��
					list.removeLast();
					list.addFirst(id);
				} else {
					// ����<3 ����ǰ������ǰ��
					list.addFirst(id);
				}

			}
			ids = "";
			// ��listת���ַ���
			for (String s : list) {
				ids += (s + "-");
			}
			ids = ids.substring(0, ids.length() - 1);
		}
		// ��idsд��ȥ
		c = new Cookie("ids", ids);
		// ���÷���·��
		c.setPath(request.getContextPath() + "/");
		// ���ô��ʱ��
		c.setMaxAge(3600);
		// д�������
		response.addCookie(c);
		// 3.��ת��ָ������Ʒҳ��
		response.sendRedirect(request.getContextPath() + "/product_info" + id + ".htm");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
