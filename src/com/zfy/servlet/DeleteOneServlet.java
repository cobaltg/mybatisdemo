package com.zfy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfy.service.MaintainService;

/**
 * 单条删除servlet
 * @author think
 *
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接收页面参数
		String id=req.getParameter("id"); 
		MaintainService maintainservice=new MaintainService();
		maintainservice.deleteOne(id); 
	    //向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
