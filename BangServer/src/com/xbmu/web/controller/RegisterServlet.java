package com.xbmu.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.xbmu.bean.User;
import com.xbmu.service.BussinessService;
import com.xbmu.service.impl.BussinessServiceImpl;

/**
 * Servlet3.0以后出现了注解。因此Servlet配置方式就有了两种： 
 * 1、在web.xml文件中配置。
 * 2、通过注解配置。
 * 		比如：@WebServlet(urlPatterns="/android/login.jsp")配置后，客户端就可以通过访问此路径访问该servlet
 */
@WebServlet(urlPatterns = "/android/register.jsp")
public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {															
		//获取模式请求参数。android：表示客户端请求地址，web表示后台请求地址
		String mode = request.getParameter("mode");
		
		String userName1 = request.getParameter("userName");
 		String userName = new String(userName1.getBytes("ISO-8859-1"),"utf-8");	
		String userPassword = request.getParameter("userPassword");
		String email = request.getParameter("e-mail");
		Integer schoolYear = Integer.parseInt(request.getParameter("schoolYear"));
		String userDesc = request.getParameter("userDesc");
 		//String userDesc = new String(userDesc1.getBytes("ISO-8859-1"),"utf-8");			
 		Integer role = Integer.parseInt(request.getParameter("role"));
 		Integer concernId = Integer.parseInt(request.getParameter("concernId"));
 		// 获取业务逻辑对象
 		BussinessService service = new BussinessServiceImpl();
		User user = new User(userName, userPassword, email, schoolYear,
				userDesc, role, concernId);
		
		Integer userId = 0;
		userId = service.register(user);
		if("android".equals(mode)){
			//userId>0表示注册成功
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
			if (userId > 0) {
				//转发到首页
				request.getRequestDispatcher("/manage/index.jsp").forward(
						request, response);
			}
			else {
				//注册失败
				response.getWriter().write("注册失败");
				//返回错误信息！
				//request.getRequestDispatcher("/manage/register.jsp").forward(
				//		request, response);
				response.setHeader("Refresh", "2;URL=" + request.getContextPath()
						+ "/manage/register.jsp");
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
