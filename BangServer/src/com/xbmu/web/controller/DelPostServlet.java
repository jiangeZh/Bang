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
 * 删除文章
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = "/android/delPost.jsp")
public class DelPostServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		Integer userId = (Integer) request.getSession(true).getAttribute(
				"userId");;
		Integer postId = Integer.parseInt(request.getParameter("postId"));
		// 获取业务逻辑对象
		BussinessService service = new BussinessServiceImpl();
		
		service.delPostByUserIdAndResId(userId, postId);
		
		if ("android".equals(mode)) {
			response.getWriter().println("删除成功!");
		} else if ("web".equals(mode)) {
			response.getWriter().write("删除成功。2秒后自动转向原页面");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath()
					+ "/servlet/ViewOwnerPostServlet?mode=web&op=owner");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
