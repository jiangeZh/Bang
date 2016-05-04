package com.xbmu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SetAllCharacterEncodingFilter implements Filter {

	private FilterConfig filterConfig;

	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request;
		HttpServletResponse response;
		try {
			request = (HttpServletRequest) req;
			response = (HttpServletResponse) res;
		} catch (ClassCastException e) {
			throw new ServletException("non-HTTP request or response");
		}
		//获取encoding的参数
		String encoding = filterConfig.getInitParameter("encoding");
		if(encoding==null){
			encoding = "UTF-8";
		}
		request.setCharacterEncoding(encoding);//POST
		response.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset="+encoding);
		
		chain.doFilter(request, response);
	}

	public void destroy() {

	}

}
