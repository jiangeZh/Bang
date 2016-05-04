package com.xbmu.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import com.xbmu.business.ResourceBean;
import com.xbmu.service.BussinessService;
import com.xbmu.service.impl.BussinessServiceImpl;

/**
 * 查看收藏资源的Servlet
 * 
 * @author Administrator
 * 
 */
@WebServlet(urlPatterns = "/android/viewFavoritesRes.jsp")
public class ViewFavoritesResServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求参数，这个参数标记的是返回的json数据，用于提供给客户端
		String mode = request.getParameter("mode");
		// 获取userId
		Integer userId = (Integer) request.getSession(true).getAttribute(
				"userId");
		// 获取业务逻辑对象
		BussinessService service = new BussinessServiceImpl();
		// 查询所有收藏文章
		List<ResourceBean> resources = service.getFavoritesResByOwner(userId);
		
		if("android".equals(mode)){
			//返回json数据提供给客户端
			JSONArray jsonArray = new JSONArray(resources);
			response.getWriter().println(jsonArray.toString());

		}else if("web".equals(mode)){
			//将数据保存在request域中，显示在服务端界面上
			request.setAttribute("resources", resources);
			request.getRequestDispatcher("/manage/viewFavoritesRes.jsp").forward(
					request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}