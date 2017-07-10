package com.itheima.f_path;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet ��servlet������ʱ�򣬴�web.xml�л�ȡ���ݿ��������Ϣ
 */
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Test() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {   
          
        Enumeration enumeration = config.getInitParameterNames();  
        while(enumeration.hasMoreElements()){  
            String name = (String) enumeration.nextElement();  
            String value = config.getInitParameter(name);  
              
            System.out.println("name----------->"+name);  
            System.out.println("value-----------     >"+value);  
        }  
    } 

}
