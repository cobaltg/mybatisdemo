package com.zfy.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfy.bean.Message;
import com.zfy.entity.Page;
import com.zfy.service.ListService;

/**
 * 消息列表查询控制层
 * @author think
 *
 */
@SuppressWarnings("serial")
public class ListServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//接受页面的值
		String command=req.getParameter("command");
		String description=req.getParameter("description");
		
		//向页面传输参数ֵ
		req.setAttribute("command", command);
		req.setAttribute("description", description);	
	    //执行service层
		ListService listService=new ListService();			
		req.setAttribute("messageList", listService.queryMessageList(command, description));
	    //跳转页面
		req.getRequestDispatcher("//WEB-INF//jsp//back//list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
