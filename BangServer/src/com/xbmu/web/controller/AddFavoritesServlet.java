package com.xbmu.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.xbmu.bean.FavoritesPost;
import com.xbmu.bean.FavoritesRes;
import com.xbmu.business.FavoritesResBean;
import com.xbmu.service.BussinessService;
import com.xbmu.service.impl.BussinessServiceImpl;
import java.util.UUID;

/**
 * 添加收藏
 * 
 * @author Administrator
 * 
 */
@WebServlet(urlPatterns = "/android/addFavorites.jsp")
public class AddFavoritesServlet extends HttpServlet {
	// 获取业务逻辑对象
	BussinessService service = new BussinessServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mode = request.getParameter("mode");
		String op = request.getParameter("op");
		// 获取userId
		Integer userId = (Integer) request.getSession(true).getAttribute(
				"userId");
		Integer resultId = -1;
		if ("post".equals(op)) {
			// 获取postId
			Integer postId = Integer.parseInt(request.getParameter("postId"));
			FavoritesPost favoritesPost = new FavoritesPost(userId, postId);
			resultId = service.addFavoritesPost(favoritesPost);
			if("android".equals(mode)){
				// 添加成功
				if (resultId > 0) {
					response.getWriter().println("恭喜您，收藏成功!");
				} else {
					response.getWriter().println("对不起，收藏失败!");
				}
			}else if("web".equals(mode)){
				response.getWriter().write("收藏成功。2秒后自动转向收藏页面");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath()
						+ "/servlet/ViewFavoritesPostServlet?mode=web");
			}
		} else if ("res".equals(op)) {
			// 获取resId
			Integer resId = Integer.parseInt(request.getParameter("resId"));
			FavoritesRes favoritesRes = new FavoritesRes(userId, resId);
			resultId = service.addFavoritesRes(favoritesRes);
			if("android".equals(mode)){
				// 添加成功
				if (resultId > 0) {
					response.getWriter().println("恭喜您，收藏成功!");
				} else {
					response.getWriter().println("对不起，收藏失败!");
				}
			}else if("web".equals(mode)){
				response.getWriter().write("收藏成功。2秒后自动转向收藏页面");
				response.setHeader("Refresh", "2;URL=" + request.getContextPath()
						+ "/servlet/ViewFavoritesResServlet?mode=web");
			}
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
