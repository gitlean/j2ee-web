package com.isoft.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.isoft.utils.RemoteAddrUtil;

/**
 * Servlet implementation class MyFirstServlet
 */
public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyFirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("------------------------------------");
		String requestIpAddr = RemoteAddrUtil.getRequestIpAddr(request);
		System.out.println(requestIpAddr);
		
		
		Enumeration<String> en=request.getHeaderNames();
		while(en.hasMoreElements()){
			String headerName=en.nextElement();
			
			String headerValue=request.getHeader(headerName);
			System.out.println(headerName+":"+headerValue);
			
		}
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Enumeration<String> en=request.getHeaderNames();
		while(en.hasMoreElements()){
			String headerName=en.nextElement();
			
			String headerValue=request.getHeader(headerName);
			System.out.println(headerName+":"+headerValue);
			
		}
		
		
		
		
		InputStream ins=request.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(ins));
		String line=null;
		while(null!=(line=reader.readLine())){
			System.out.println(line);
		}
		
		doGet(request, response);
	}

}
