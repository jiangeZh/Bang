package com.xbmu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.xbmu.business.KindBean;
import com.xbmu.service.BussinessService;
import com.xbmu.service.impl.BussinessServiceImpl;

/**
 * 查看所有分类的Servlet
 * 
 * @author Administrator
 * 
 */
@WebServlet(urlPatterns="/android/viewKind.jsp")
public class ViewKindServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BussinessService service = new BussinessServiceImpl();
		List<KindBean> kinds = service.getAllKind();
		String mode = request.getParameter("mode");
		if("android".equals(mode)){
			JSONArray jsonArray = new JSONArray(kinds);
			response.getWriter().println(jsonArray.toString());		
		}else if("web".equals(mode)){
			request.setAttribute("kinds", kinds);
			request.getRequestDispatcher("/manage/viewKind.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
