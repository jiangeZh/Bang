package com.xbmu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.xbmu.bean.Post;
import com.xbmu.bean.FavoritesPost;
import com.xbmu.dao.FavoritesPostDao;
import com.xbmu.util.DBCPUtil;

public class FavoritesPostDaoImpl implements FavoritesPostDao {
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	
	/**
	 * 查询用户收藏
	 * @param userId 用户id
	 * @return 收藏的文章列表
	 */
	public List<Post> findFavoritesPostByOwner(Integer userId) {		
		try {
			String sql = "select * from post where post_id in" +
					"(select post_id from favorites_post where user_id=?)";
			List<Post> posts = qr.query(sql, new BeanListHandler<Post>(Post.class), userId);
			return posts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 添加收藏文章
	 * @param post 待添加的文章
	 */
	public void save(FavoritesPost favoritesPost) {
		try {
			String sql = "insert into favorites_post (user_id,post_id) values(?,?)";
			qr.update(sql, favoritesPost.getUser_id(),favoritesPost.getPost_id());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
