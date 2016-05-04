package com.xbmu.dao;

import java.util.List;

import com.xbmu.bean.Post;
import com.xbmu.bean.FavoritesPost;

public interface FavoritesPostDao {
	/**
	 * 查询用户收藏
	 * @param userId 用户id
	 * @return 收藏的文章列表
	 */
	List<Post> findFavoritesPostByOwner(Integer userId);
	
	/**
	 * 添加收藏文章
	 * @param post 待添加的文章
	 */
	void save(FavoritesPost favoritesPost);
}
