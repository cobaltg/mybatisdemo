package com.zfy.servlet;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zfy.entity.Page;
import com.zfy.service.QueryService;

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
		//获取当前页面的页数
		String currentPage=req.getParameter("currentPage");
		//创建分页对象
		Page page=new Page();
		Pattern pattern=Pattern.compile("[0-9]{1,9}");
		if(currentPage==null||!pattern.matcher(currentPage).matches()){
			page.setCurrentPage(1);
		}else{
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		QueryService listService=new QueryService();
		//查询消息列表并传给页面
		req.setAttribute("messageList", listService.queryMessageList(command, description, page));
		//向页面传输参数ֵ
		req.setAttribute("command", command);
		req.setAttribute("description", description);	
		req.setAttribute("page", page);		
	    //跳转页面
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
