package com.itheima.request.f_param;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("name:" + name);
		String[] hobby = request.getParameterValues("hobby");
		System.out.println(Arrays.toString(hobby));
		System.out.println("============================");

		Map<String, String[]> parameterMap = request.getParameterMap();
		for (String key : parameterMap.keySet()) {
			System.out.println(key+"::"+Arrays.toString(parameterMap.get(key)));
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
