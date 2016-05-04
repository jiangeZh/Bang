package com.xbmu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbmu.service.BussinessService;
import com.xbmu.service.impl.BussinessServiceImpl;

/**
 * 增加感谢数
 * 
 * @author Administrator
 * 
 */
@WebServlet(urlPatterns = "/android/IncrPostThx.jsp")
public class IncrPostThxServlet extends HttpServlet {
	// 获取业务逻辑对象
	BussinessService service = new BussinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取postId
		Integer postId = Integer.parseInt(request.getParameter("postId"));
		service.incrPostThx(postId);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
