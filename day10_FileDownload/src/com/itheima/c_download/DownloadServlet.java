package com.itheima.c_download;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �ļ�����
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ�����ļ�������
		String filename = request.getParameter("name");
		//ע����������
		filename = new String(filename.getBytes("iso8859-1"),"utf-8");
		
		
		
		ServletContext context = this.getServletContext();
		//�ļ�����
		//1.�����ļ���mimeType
		String mimeType = context.getMimeType(filename);
		response.setContentType(mimeType);
		//2.�������ص�ͷ��Ϣ
		response.setHeader("content-disposition", "attachment;filename="+filename);
		
		//3.�Կ���
		//��ȡ������
		InputStream is = context.getResourceAsStream("/download/"+filename);
		
		//��ȡ�����
		ServletOutputStream os = response.getOutputStream();
		int len = -1;
		byte[] b = new byte[1024];
		
		while((len=is.read(b))!=-1){
			os.write(b, 0, len);
		}
		os.close();
		is.close();	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
