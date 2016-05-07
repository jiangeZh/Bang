package com.xbmu.dao;

import java.util.List;

import com.xbmu.bean.Post;

public interface PostDao
{
	/**
	 * 获取文章
	 * @param
	 */
	List<Post> findAllPost();
	/**
	 * 根据种类获取文章
	 * @param kindId ;
	 * @return 文章列表
	 */
	List<Post> findPostByKind(Integer kindId);

	/**
	 * 根据发布者获取文章
	 * @param useId ;
	 * @return 文章列表
	 */
	List<Post> findPostByOwner(Integer userId);
	/**
	 * 添加文章
	 * @param post
	 */
	
	/**
	 * 增加文章的感谢数
	 * @param postId 文章id;
	 * @return void
	 */
	void incrPostThx(int postId);
	
	void save(Post post);
	
	/**
	 * 删除文章
	 * @param userId 拥有者ID
	 * @param postId 文章ID
	 */
	void del(Integer userId, Integer postId);
	/**
	 * 获取文章
	 * @param itemId 文章id
	 * @return 返回文章对象
	 */
	Post get(int postId);
}