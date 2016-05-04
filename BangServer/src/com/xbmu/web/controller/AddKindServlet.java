package com.xbmu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbmu.bean.Kind;
import com.xbmu.service.BussinessService;
import com.xbmu.service.impl.BussinessServiceImpl;

@WebServlet(urlPatterns = "/android/addKind.jsp")
public class AddKindServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		// 获取请求参数
		String name = request.getParameter("kindName");
		String desc = request.getParameter("kindDesc");
		// 获取服务类对象
		BussinessService service = new BussinessServiceImpl();
		// 调用业务逻辑层的业务方法添加种类
		int kindId = service.addKind(new Kind(name, desc));
		
		if("android".equals(mode)){
			// 添加成功
			if (kindId > 0) {
				response.getWriter().println("恭喜您，种类添加成功");
			} else {
				response.getWriter().println("对不起，种类添加失败");
			}
		}else if("web".equals(mode)){
			response.getWriter().write("添加种类。2秒后自动转向添加页面");
			response.setHeader("Refresh", "2;URL=" + request.getContextPath()
					+ "/servlet/ViewKindServlet?mode=web");
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
