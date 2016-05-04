package com.xbmu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.xbmu.business.PostBean;
import com.xbmu.service.BussinessService;
import com.xbmu.service.impl.BussinessServiceImpl;

/**
 * 查看自己发布的文章
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = "/android/viewOwnerPost.jsp")
public class ViewOwnerPostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		String op = request.getParameter("op");
		Integer userId = -1;
		// 获取业务逻辑对象
		BussinessService service = new BussinessServiceImpl();
				
		if ("owner".equals(op)) {
			userId = (Integer) request.getSession(true).getAttribute(
					"userId");
		} else if ("visitor".equals(op)) {
			String owner = request.getParameter("owner");
			userId = service.getUserId(owner);
		}
				
		List<PostBean> posts = service.getPostsByOwner(userId);
		
		if ("android".equals(mode)) {
			JSONArray jsonArray = new JSONArray(posts);
			response.getWriter().println(jsonArray.toString());
		} else if ("web".equals(mode)) {
			request.setAttribute("posts", posts);
			request.getRequestDispatcher("/manage/viewOwnerPost.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}