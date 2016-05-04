package com.xbmu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 * 权限过滤器
 * @author Administrator
 *
 */
@WebServlet(urlPatterns = "/android/*")
public class Authority implements Filter {

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest = (HttpServletRequest) request;
		String mode = hrequest.getParameter("mode");
		// 获取HttpSession对象
		HttpSession session = hrequest.getSession(true);
		Integer userId = (Integer) session.getAttribute("userId");
		if ("andorid".equals(mode)) {
			// 如果用户已经登录，或用户正在登录
			if ((userId != null && userId > 0)
					|| hrequest.getRequestURI().endsWith("/login.jsp?mode=android")) {
				// 放行请求
				chain.doFilter(request, response);
			} else {
				response.getWriter().println("您还没有登录系统，请先系统！");
			}
		}else if("web".equals(mode)){
			//TODO
		}

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
