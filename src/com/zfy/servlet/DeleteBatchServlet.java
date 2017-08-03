package com.zfy.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfy.service.MaintainService;

@SuppressWarnings("serial")
public class DeleteBatchServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接收页面参数
		String[] ids=req.getParameterValues("id"); 
		MaintainService maintainservice=new MaintainService();
		maintainservice.deleteBatch(ids); 
	    //向页面跳转
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
