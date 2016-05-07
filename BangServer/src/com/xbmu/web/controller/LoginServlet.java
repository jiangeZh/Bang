package com.xbmu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;


import com.xbmu.service.BussinessService;
import com.xbmu.service.impl.BussinessServiceImpl;

/**
 * Servlet3.0以后出现了注解。因此Servlet配置方式就有了两种： 
 * 1、在web.xml文件中配置。
 * 2、通过注解配置。
 * 		比如：@WebServlet(urlPatterns="/android/login.jsp")配置后，客户端就可以通过访问此路径访问该servlet
 */
@WebServlet(urlPatterns = "/android/login.jsp")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取模式请求参数。android：表示客户端请求地址，web表示后台请求地址
		String mode = request.getParameter("mode");
		if("android".equals(mode)){
			Integer userId = validateLogin(request);
			//userId>0表示登录成功
			try {
				JSONObject jsonObject = new JSONObject();
				//把验证的userId封装成JSONObject
				jsonObject.put("userId", userId);
				//输出响应
				response.getWriter().println(jsonObject.toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else if("web".equals(mode)){
			Integer userId = validateLogin(request);
			if (userId > 0) {
				//转发到首页
				request.getRequestDispatcher("/manage/index.jsp").forward(
						request, response);
			}
			else {
				//用户名不存在或者密码错误
				//返回错误信息！
				request.getRequestDispatcher("/manage/login.jsp").forward(
						request, response);
			}
		}
		
	}
	/**
	 * 验证用户登录
	 * @param request
	 * @return 登录成功，返回用户id
	 */
	private Integer validateLogin(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//获取业务逻辑对象
		BussinessService service = new BussinessServiceImpl();
		//验证用户登录
		Integer userId = service.validLogin(username, password);
		if (userId > 0) {
			//将用户ID放入HTTP session中，方便以后程序跟踪用户的登录状态
			request.getSession(true).setAttribute("userId", userId);
		}
		return userId;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
