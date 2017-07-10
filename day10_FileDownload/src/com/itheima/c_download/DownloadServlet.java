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
 * 文件下载
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取下载文件的名称
		String filename = request.getParameter("name");
		//注意中文乱码
		filename = new String(filename.getBytes("iso8859-1"),"utf-8");
		
		
		
		ServletContext context = this.getServletContext();
		//文件下载
		//1.设置文件的mimeType
		String mimeType = context.getMimeType(filename);
		response.setContentType(mimeType);
		//2.设置下载的头信息
		response.setHeader("content-disposition", "attachment;filename="+filename);
		
		//3.对拷流
		//获取输入流
		InputStream is = context.getResourceAsStream("/download/"+filename);
		
		//获取输出流
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
