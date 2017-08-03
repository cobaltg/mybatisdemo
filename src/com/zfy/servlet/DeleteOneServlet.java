package com.zfy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfy.service.MaintainService;

/**
 * ����ɾ��servlet
 * @author think
 *
 */
@SuppressWarnings("serial")
public class DeleteOneServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//���ñ���
		req.setCharacterEncoding("UTF-8");
		//����ҳ�����
		String id=req.getParameter("id"); 
		MaintainService maintainservice=new MaintainService();
		maintainservice.deleteOne(id); 
	    //��ҳ����ת
		req.getRequestDispatcher("/List.action").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
