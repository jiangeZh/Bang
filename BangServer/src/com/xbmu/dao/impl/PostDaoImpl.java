package com.xbmu.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.xbmu.bean.Post;
import com.xbmu.bean.Kind;
import com.xbmu.bean.User;
import com.xbmu.dao.PostDao;
import com.xbmu.util.DBCPUtil;

public class PostDaoImpl implements PostDao
{
	QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
	/**
	 * 获取文章
	 * @param
	 */
	public List<Post> findAllPost()
	{
		try {
			String sql = "select * from post";
			List<Post> posts = qr.query(sql, new BeanListHandler<Post>(
					Post.class));
			return posts;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 根据种类获取文章
	 * @param kindId ;
	 * @return 文章列表
	 */
	public List<Post> findPostByKind(Integer kindId)
	{
		try {
			// 根据种类获取文章
			String sql = "select * from post where kind_id=?";
			List<Post> posts = qr.query(sql, new BeanListHandler<Post>(
					Post.class), kindId);
			// 设置竞拍文章拥有者
			for (Post post : posts) {
				// 设置拥有者
				String ownerSql = "select * from user where user_id = any(select owner_id from post where kind_id=? and post_id=?)";
				User owner = qr.query(ownerSql, new BeanHandler<User>(
						User.class), kindId, post.getPost_id());
				post.setOwner_id(owner.getUser_id());
			}
			return posts;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据发布者获取文章
	 * @param useId ;
	 * @return 文章列表
	 */
	public List<Post> findPostByOwner(Integer userId)
	{
		try {
			String sql = "select * from post where owner_id=?";
			List<Post> posts = qr.query(sql, new BeanListHandler<Post>(
					Post.class), userId);
			// 设置物品拥有者，物品种类
			for (Post post : posts) {
				// 设置拥有者
				String ownerSql = "select * from user where user_id=any(select owner_id from post where owner_id=?)";
				User owner = qr.query(ownerSql, new BeanHandler<User>(
						User.class), userId);
				post.setOwner_id(owner.getUser_id());
				// 设置物品种类
				String kindSql = "select * from kind where kind_id = any(select kind_id from post where owner_id=?)";
				Kind kind = qr.query(kindSql,
						new BeanHandler<Kind>(Kind.class), userId);
				post.setKind_id(kind.getKind_id());
			}
			return posts;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 增加文章的感谢数
	 * @param postId 文章id;
	 * @return void
	 */
	public void incrPostThx(int postId)
	{
		try {
			String sql = "update post set thx_cnt=thx_cnt+1 where post_id=?";
			qr.update(sql, postId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	/**
	 * 添加文章
	 * @param post
	 */
	public void save(Post post) {
		try {
			String sql = "insert into post(post_title,post_text,post_date,thx_cnt,owner_id,kind_id,img_url) "
					+ //
					"values(?,?,?,?,?,?,?)";
			qr.update(sql, post.getPost_title(), post.getPost_text(), 
					post.getPost_date(), post.getThx_cnt(),
					post.getOwner_id(), post.getKind_id(), post.getImg_url());
			String sql2 = "select @@identity as post_id";
			Object post_id = qr.query(sql2, new ScalarHandler(1));
			post.setPost_id(Integer.valueOf(post_id.toString()));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	/**
	 * 获取文章
	 * @param postId 文章id
	 * @return 返回文章对象
	 */
	public Post get(int postId) {
		try {
			String sql = "select * from post where post_id=?";
			Post post = qr
					.query(sql, new BeanHandler<Post>(Post.class), postId);
			// 设置物品种类
			String kindSql = "select * from kind where kind_id = any(select kind_id from post where post_id=?)";
			Kind kind = qr.query(kindSql, new BeanHandler<Kind>(Kind.class),
					postId);
			post.setKind_id(kind.getKind_id());
			// 设置拥有者
			String ownerSql = "select * from user where user_id = any(select owner_id from post where post_id=?)";
			User owner = qr.query(ownerSql, new BeanHandler<User>(User.class),
					post.getPost_id());
			post.setOwner_id(owner.getUser_id());
			return post;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void del(Integer userId, Integer postId) {
		try {
			String sql = "delete from post where post_id=? and owner_id=?";
			qr.update(sql, postId, userId);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
}