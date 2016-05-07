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
 * 删除资源
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = "/android/delResource.jsp")
public class DelResourceServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		Integer userId = (Integer) request.getSession(true).getAttribute(
				"userId");;
		Integer resId = Integer.parseInt(request.getParameter("resId"));
		// 获取业务逻辑对象
		BussinessService service = new BussinessServiceImpl();
		
		service.delResourceByUserIdAndResId(userId, resId);
		
		if ("android".equals(mode)) {
			response.getWriter().println("删除成功!");
		} else if ("web".equals(mode)) {
			response.getWriter().write("删除成功。2秒后自动转向原页面");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath()
					+ "/servlet/ViewOwnerResourceServlet?mode=web&op=owner");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
